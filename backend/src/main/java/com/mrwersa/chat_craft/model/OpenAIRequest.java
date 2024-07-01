package com.mrwersa.chat_craft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OpenAIRequest {
    private final String prompt;
}
