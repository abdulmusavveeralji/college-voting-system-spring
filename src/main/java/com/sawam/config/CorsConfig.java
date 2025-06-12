package com.sawam.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Apply CORS to all endpoints under /api/
                        .allowedOrigins("http://localhost:4200") // Your Angular app's origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Crucial: Include OPTIONS
                        .allowedHeaders("*") // Allow all headers (e.g., Content-Type, Authorization)
                        .allowCredentials(true) // If you use cookies or auth headers
                        .maxAge(3600); // Cache preflight response for 1 hour
            }
        };
    }
}
