package com.fuze.potryservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ServiceConfigurationError;

@Configuration
public class WebSocketConfig {
    @Bean
    public ServiceConfigurationError serverEndpointServer() {
        return new ServiceConfigurationError("");
    }
}
