package com.mrwersa.chat_craft.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CodeGenerationService {

    private final OpenAIService openAIService;

    public Mono<String> generateCode(String appName, String description) {
        String prompt = "Generate a responsive web application in Appsmith named " + appName
                + ". The application should serve the following purpose: "
                + description;
        return openAIService.generateCode(prompt);
    }
}
