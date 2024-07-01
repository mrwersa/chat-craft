package com.mrwersa.chat_craft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ChatCraftApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChatCraftApplication.class, args);
	}
}
