package com.mrwersa.chat_craft.api;

import com.mrwersa.chat_craft.model.AppDesignRequest;
import com.mrwersa.chat_craft.model.GeneratedCodeResponse;
import com.mrwersa.chat_craft.service.AppsmithService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import jakarta.validation.Valid;

@RestController
public class CodeGenerationController implements CodeGenerationApi {

    private final AppsmithService appsmithService;

    public CodeGenerationController(AppsmithService appsmithService) {
        this.appsmithService = appsmithService;
    }

    @Override
    public Mono<GeneratedCodeResponse> generateCode(@Valid Mono<AppDesignRequest> appDesignRequest,
            ServerWebExchange exchange) {
        return appDesignRequest.flatMap(request -> appsmithService.generateAppForAppsmith(
                request.getAppName(), request.getDescription()));
    }
}
