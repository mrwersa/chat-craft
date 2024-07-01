package com.mrwersa.chat_craft.model;

import lombok.Data;
import java.util.List;

@Data
public class OpenAIResponse {
    private List<Choice> choices;

    @Data
    public static class Choice {
        private String text;
    }
}
