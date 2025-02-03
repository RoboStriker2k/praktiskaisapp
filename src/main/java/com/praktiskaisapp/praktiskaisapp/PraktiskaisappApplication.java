package com.praktiskaisapp.praktiskaisapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.praktiskaisapp.Rest.Repositories.ComputerRepository;
import com.praktiskaisapp.Rest.Repositories.RecordsRepository;

@SpringBootApplication
public class PraktiskaisappApplication implements WebMvcConfigurer {
	public static void main(String[] args) {
		SpringApplication.run(PraktiskaisappApplication.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("templates/**").addResourceLocations("classpath:/templates/");
		registry.addResourceHandler("/**").addResourceLocations("classpath:/", "classpath:/index.html", "classpath:/browser/index.html", "classpath:/static/");

	}
}
