package cn.edu.bjut.ai.service.impl;

import cn.edu.bjut.ai.service.AliAiService;
import org.springframework.stereotype.Service;

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

@Service
public class AliAiServiceImpl implements AliAiService {

    @Override
    public String answerQuestion(String question)
        throws NoApiKeyException, ApiException, InputRequiredException {
            Generation gen = new Generation();
            Constants.apiKey = "sk-sW3rj3Dueu";
            MessageManager msgManager = new MessageManager(4000);
            Message systemMsg =
                    Message.builder().role(Role.SYSTEM.getValue()).content("You are a helpful assistant.").build();
            Message userMsg = Message.builder().role(Role.USER.getValue()).content(question).build();
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
}
