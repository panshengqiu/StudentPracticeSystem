package cn.edu.bjut.websocket.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Friends {
    /**
     * 好友昵称
     */
    private String nickname;
}
