package cn.edu.bjut.ai;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.aigc.generation.models.QwenParam;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.MessageManager;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.utils.Constants;

import java.util.Scanner;

public class Main {
    public static String callWithMessage(String input)
            throws NoApiKeyException, ApiException, InputRequiredException {
        Generation gen = new Generation();
        Constants.apiKey = "sk-sW3rj3Dueu";
        MessageManager msgManager = new MessageManager(4000);
        Message systemMsg =
                Message.builder().role(Role.SYSTEM.getValue()).content("You are a helpful assistant.").build();
        Message userMsg = Message.builder().role(Role.USER.getValue()).content(input).build();
        msgManager.add(systemMsg);
        msgManager.add(userMsg);
        QwenParam param =
                QwenParam.builder().model(Generation.Models.QWEN_TURBO).messages(msgManager.get())
                        .resultFormat(QwenParam.ResultFormat.MESSAGE)
                        .build();
        GenerationResult result = gen.call(param);
        String message = new String(result.getOutput().getChoices().get(0).getMessage().getContent());
        return message;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("请输入您的问题，输入'done'退出程序：\n");
        while (!(input = scanner.nextLine()).equals("done")) {
            try {
                String message = callWithMessage(input);
                System.out.println(message);
            } catch (ApiException | NoApiKeyException | InputRequiredException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
        System.exit(0);
    }
}
