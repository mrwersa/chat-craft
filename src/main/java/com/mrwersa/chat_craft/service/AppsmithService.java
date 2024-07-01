package com.mrwersa.chat_craft.service;

import com.mrwersa.chat_craft.model.AppsmithRequest;
import com.mrwersa.chat_craft.model.AppsmithResponse;
import com.mrwersa.chat_craft.model.GeneratedCodeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class AppsmithService {

    private final CodeGenerationService codeGenerationService;
    private final WebClient.Builder webClientBuilder;

    @Value("${appsmith.api.url}")
    private String apiUrl;

    public Mono<GeneratedCodeResponse> generateAppForAppsmith(String appName, String description) {
        return codeGenerationService.generateCode(appName, description)
                .flatMap(generatedCode -> createAppInAppsmith(generatedCode)
                        .map(appId -> new GeneratedCodeResponse(generatedCode,
                                "App created successfully with ID: " + appId, OffsetDateTime.now())));
    }

    private Mono<String> createAppInAppsmith(String code) {
        WebClient webClient = webClientBuilder.baseUrl(apiUrl).build();
        return webClient.post()
                .uri("/apps")
                .bodyValue(new AppsmithRequest(code))
                .retrieve()
                .bodyToMono(AppsmithResponse.class)
                .map(AppsmithResponse::getAppId);
    }

    public Mono<String> fetchGeneratedApp(String appId) {
        WebClient webClient = webClientBuilder.baseUrl(apiUrl).build();
        return webClient.get()
                .uri("/apps/{appId}", appId)
                .retrieve()
                .bodyToMono(String.class);
    }
}
