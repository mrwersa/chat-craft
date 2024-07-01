package com.mrwersa.chat_craft.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CodeGenerationService {

    private final OpenAIService openAIService;

    public Mono<String> generateCode(String appName, String description) {
        String prompt = "Generate a responsive web application named " + appName + " with the following description: "
                + description;
        return openAIService.generateCode(prompt);
    }
}
