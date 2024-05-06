package cn.edu.bjut.ai.controller;


import cn.edu.bjut.ai.service.AliAiService;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AliyunAIController {
    @Autowired
    private AliAiService aliAiService;
    @GetMapping("/chat/ai-chat")
    public String gptChat(@RequestParam String question) throws NoApiKeyException, InputRequiredException {
        String answer = aliAiService.answerQuestion(question);
        return answer;
    }
}
