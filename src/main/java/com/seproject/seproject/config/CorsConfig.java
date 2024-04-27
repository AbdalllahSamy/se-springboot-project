package com.seproject.seproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Replace with the origin of your React frontend
                .allowedMethods("*")
                .allowedHeaders("Authorization", "Content-Type", "Accept") // Explicitly allow the Authorization header
                .allowCredentials(true); // Allow credentials with specific origin
    }
}
