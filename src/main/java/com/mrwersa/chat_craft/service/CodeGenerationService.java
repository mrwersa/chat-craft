package com.mrwersa.chat_craft.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CodeGenerationService {

    private final OpenAIService openAIService;

    public Mono<String> generateCode(String appName, String description) {
        // Use markers or delimiters to wrap the generated code placeholder
        String prompt = "Generate a responsive web application in Appsmith named \"" + appName
                + "\". This application should serve the following description: \"" + description + "\". "
                + "Include interactive components like forms and charts, "
                + "and integrate with external APIs for data retrieval and manipulation. "
                + "Ensure the design is user-friendly and optimized for performance. "
                + "Wrap the generated code between CODE_START_PLACEHOLDER and CODE_END_PLACEHOLDER.";
        return openAIService.generateCode(prompt);
    }
}
