package com.vertex.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.vertx.core.Vertx;

@Configuration
public class VertexConfig {

    @Bean
    public Vertx vertx() {
        return Vertx.vertx();
    }
}
