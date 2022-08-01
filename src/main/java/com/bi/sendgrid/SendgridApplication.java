package com.bi.sendgrid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SendgridApplication {

	@Value("${send-grid.base.url}")
	public String sendGridBaseUrl;

	@Value("${send-grid.api.key}")
	private String sendGridApiKey;

	public static void main(String[] args) {
		SpringApplication.run(SendgridApplication.class, args);
	}

	@Bean
	public WebClient webClient() {
		return WebClient.builder()
				.baseUrl(sendGridBaseUrl)
				.defaultHeader(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", sendGridApiKey))
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}
}
