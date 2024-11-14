package com.slippery.booklibrary.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("https://book-store-ui-ten.vercel.app")
                        .allowedMethods("GET","DELETE","POST","PUT");
            }
        };
    }
}
