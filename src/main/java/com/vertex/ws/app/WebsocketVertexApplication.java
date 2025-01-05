package com.vertex.ws.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.vertex.ws"})
public class WebsocketVertexApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketVertexApplication.class, args);
	}
}