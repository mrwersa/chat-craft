package com.mrwersa.chat_craft.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class OpenAIService {

    private final WebClient webClient;

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.url}")
    private String apiUrl;

    public OpenAIService(WebClient.Builder webClientBuilder, @Value("${openai.api.key}") String apiKey,
            @Value("${openai.api.url}") String apiUrl) {
        this.webClient = webClientBuilder.build();
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
    }

    public Mono<String> generateCode(String prompt) {
        return webClient.post()
                .uri(apiUrl)
                .header("Authorization", "Bearer " + apiKey)
                .bodyValue(new OpenAIRequest(prompt))
                .retrieve()
                .bodyToMono(OpenAIResponse.class)
                .map(this::extractGeneratedCode);
    }

    private String extractGeneratedCode(OpenAIResponse response) {
        String generatedText = response.getChoices().get(0).getText();
        // Find the start and end indexes of the generated code
        int startIndex = generatedText.indexOf("CODE_START_PLACEHOLDER") + "CODE_START_PLACEHOLDER".length();
        int endIndex = generatedText.indexOf("CODE_END_PLACEHOLDER");
        if (startIndex != -1 && endIndex != -1 && endIndex > startIndex) {
            return generatedText.substring(startIndex, endIndex).trim();
        } else {
            throw new IllegalStateException("Generated code not found in response");
        }
    }

    @Data
    @AllArgsConstructor
    static class OpenAIRequest {
        private String prompt;
    }

    @Data
    static class OpenAIResponse {
        private List<Choice> choices;

        @Data
        static class Choice {
            private String text;
        }
    }
}
