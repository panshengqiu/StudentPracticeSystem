package cn.edu.bjut.ai.service;

import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;

public interface AliAiService {
    String answerQuestion(String question) throws NoApiKeyException, InputRequiredException;
}
