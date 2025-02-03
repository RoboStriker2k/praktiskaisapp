package com.praktiskaisapp.praktiskaisapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
public class PraktiskaisappApplication implements WebMvcConfigurer {
	public static void main(String[] args) {
		SpringApplication.run(PraktiskaisappApplication.class, args);
	}

	@Override
	public void addResourceHandlers(@SuppressWarnings("null") ResourceHandlerRegistry registry) {
		registry.addResourceHandler("static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("templates/**").addResourceLocations("classpath:/templates/");
		registry.addResourceHandler("/**").addResourceLocations("classpath:/", "classpath:/index.html", "classpath:/browser/index.html", "classpath:/static/");
	}
	





}
