package com.spartan.ws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.spartan.ws.handlers.MessageHandlerUtil;
import com.spartan.ws.handlers.WebSocketMessageHandler;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import jakarta.annotation.PostConstruct;

@Component
public class VertexSocketService extends AbstractVerticle {

	@Autowired
	private Vertx vertx;

	@Autowired
	@Lazy
	private MessageHandlerUtil msgHandlerUtil;
	@Autowired
	private WebSocketMessageHandler webSocketMessageHandler;
	
	@Value("${socket.port}")
	private int  port;

	@PostConstruct
	public void startService() {
		System.out.println("start Vetx service");
		vertx.deployVerticle(this);
	}

	@Override
	public void start() {
		HttpServer server = vertx.createHttpServer();
		
		System.out.println("Start the vertex server");
        
		server.webSocketHandler(socket -> {
			socket.textMessageHandler(message -> webSocketMessageHandler.handleSocket(socket));
		}).listen(port, http -> {
			if (http.succeeded()) {
				System.out.println("WebSocket server started on port"+port);
			} else {
				System.err.println("WebSocket server failed to start");
			}
		});
	}
}
