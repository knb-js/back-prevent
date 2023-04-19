package com.back.prev.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@Getter
public class ConfigValues {

	@Value("${url.front}")
	private String urlFront;
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@Value("${url.front.reset.password}")
	private String urlFrontResetPassword;
	
}
