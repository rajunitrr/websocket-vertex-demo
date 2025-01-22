package com.spartan.ws.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spartan.ws.util.MessageConstants;

import io.vertx.core.http.ServerWebSocket;
import io.vertx.core.json.JsonObject;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthenticationHandler implements MessageHandler {

	@Autowired
	private MessageHandlerUtil msgUtil;

	@PostConstruct
	public void register() {

		msgUtil.registerHandlers(MessageConstants.WS_AUTHENTICATION_REQUEST, this);

		log.info("Registered AuthenticationHandler");
	}

	@Override
	public void processMessage(ServerWebSocket session, String message) {
		
		
		//TO DO : Validate the token 
		
		
		
		JsonObject response = new JsonObject().put("msgId", MessageConstants.WS_AUTHENTICATION_RESPONSE)
				.put("status", "success");
		session.writeTextMessage(response.encode());

	}

}
