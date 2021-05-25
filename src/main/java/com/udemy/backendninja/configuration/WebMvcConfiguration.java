package com.udemy.backendninja.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.udemy.backendninja.component.RequestTimeInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	
	private RequestTimeInterceptor requestTimeInterceptor;
	@Autowired
	public WebMvcConfiguration(RequestTimeInterceptor requestTimeInterceptor) {
		this.requestTimeInterceptor = requestTimeInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestTimeInterceptor);
	}

}
