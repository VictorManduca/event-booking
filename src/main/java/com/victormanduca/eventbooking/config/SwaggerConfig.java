package com.victormanduca.eventbooking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@EnableWebMvc
@OpenAPIDefinition(info = @Info(title = "Event booking api", version = "1.0", description = "API to manipulate events and its participants"))
public class SwaggerConfig {
}