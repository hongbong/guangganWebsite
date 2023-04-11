package com.guanggan.website.service;

/**
 * @NAME: OpenAiChatBiz
 * @USER: hongbong
 * @DATE: 2023/4/6
 * @TIME: 18:04
 **/
//import com.google.common.collect.Maps;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;

@Slf4j
@Service
public class OpenAiChatBiz {

    @Value("${open.ai.model}")
    private String openAiModel;
    @Autowired
    private OpenAiService openAiService;
    /**
     * 聊天
     * @param prompt
     * @return
     */
    public String chat(String prompt){
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .model(openAiModel)
                .echo(true)
                .temperature(0.7)
                .topP(1d)
                .frequencyPenalty(0d)
                .presencePenalty(0d)
                .maxTokens(1000)
                .build();
        CompletionResult completionResult = openAiService.createCompletion(completionRequest);
        String text = completionResult.getChoices().get(0).getText();
        return text;
    }


}
