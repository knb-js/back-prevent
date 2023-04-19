package com.back.prev.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;

@Component
public class ConfigClient {
	
	@Value("${client.service.timeout.connection}")
	static String TIMEOUT_CONNECTION_SERVICE;
	
	@Value("${client.service.timeout.read}")
	static String TIMEOUT_READ_SERVICE;
	
	
    //timeouts in request
	 public static SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
		    SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		    //Connect timeout
		    clientHttpRequestFactory.setConnectTimeout(100000);
		    //Read timeout
		    clientHttpRequestFactory.setReadTimeout(100000);
		    return clientHttpRequestFactory;
	 }
}
