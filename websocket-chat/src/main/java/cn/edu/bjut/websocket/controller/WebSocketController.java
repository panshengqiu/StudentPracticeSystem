package cn.edu.bjut.websocket.controller;

import cn.edu.bjut.websocket.entity.Friends;
import cn.edu.bjut.websocket.entity.Messages;
import com.alibaba.fastjson.JSON;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Slf4j
@Component
@ServerEndpoint(value = "/websocket/{nickname}")
public class WebSocketController {
    private Session session;

    /**
     * 好友列表
     */
    public static List<Friends> friendsList = new ArrayList<>();

    /**
     * 定义并发HashMap存储好友WebSocket集合
     */
    public static ConcurrentHashMap<String, WebSocketController> webSocketSession = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(@PathParam(value = "nickname") String nickname, Session session) {
        // 设置session
        this.session = session;
        // Put添加当前类
        webSocketSession.put(nickname, this);
        // Add添加当前好友信息
        friendsList.add(Friends.builder().nickname(nickname).build());
        // 通知更新好友信息列表
        updateFriendInformationList();

        log.info("【WebSocket消息】有新的连接[{}], 连接总数:{}", nickname, webSocketSession.size());
    }

    /**
     * 通知更新好友信息列表
     */
    private synchronized void updateFriendInformationList() {
        webSocketSession.forEach((key, val) -> {
            // 初始化存储属于自己的好友列表 排除自己
            List<Friends> friends = new ArrayList<>();
            // 迭代所有好友列表
            friendsList.forEach((friend) -> {
                // 在 所有好友信息列表 中验证非自己
                if (!friend.getNickname().equals(key)) {
                    // 追加非自己的好友信息
                    friends.add(friend);
                }
            });
            // 发送消息
            sendP2PMessage(key, JSON.toJSONString(Messages.builder().type("updateFriendsList").sendNickname(key).messages(friends).build()));
        });
    }

    @OnMessage
    public void onMessage(@PathParam(value = "nickname") String nickname, String message) {
        log.info("【WebSocket消息】 收到客户端[{}] 发送消息:{} 连接总数:{}", nickname, message, webSocketSession.size());

        // 验证消息内容
        if (StringUtils.hasLength(message)) {
            try {
                // 消息内容转消息对象
                Messages messages = JSON.parseObject(message, Messages.class);
                // 发送消息
                sendP2PMessage(messages.getReceiveNickname(), message);
            } catch (Exception e) {
                log.error("WebSocket消息异常:", e);
            }
        }
    }

    @OnClose
    public void onClose(@PathParam(value = "nickname") String nickname) {
        friendsList.remove(friendsList.stream().filter((friends -> friends.getNickname().equals(nickname))).findAny().orElse(null));
        webSocketSession.remove(nickname);
        // 通知更新好友信息列表
        updateFriendInformationList();
        log.info("【WebSocket消息】客户端[{}]连接断开, 剩余连接总数:{}", nickname, webSocketSession.size());
    }

    /**
     * 点对点发送
     */
    public static synchronized void sendP2PMessage(String nickname, String message) {
        log.info("【WebSocket消息】点对点发送消息, nickname={} , message={}", nickname, message);
        try {
            webSocketSession.get(nickname).session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.error("点对点发送异常:", e);
        }
    }

}
