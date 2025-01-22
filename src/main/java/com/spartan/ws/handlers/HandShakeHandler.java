package com.spartan.ws.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spartan.ws.util.MessageConstants;

import io.vertx.core.http.ServerWebSocket;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HandShakeHandler implements MessageHandler {

	@Autowired
	private MessageHandlerUtil msgHandlerUtil;

	@PostConstruct
	public void register() {

		msgHandlerUtil.registerHandlers(MessageConstants.WS_HANDLER_HANDSHAKE, this);
		log.info("Registered HandShakeHandler");
	}

	@Override
	public void processMessage(ServerWebSocket session, String message) {
		String responseMessage = msgHandlerUtil.buildMessage(MessageConstants.WS_MSG_HANDSHAKE_RESPONSE,"HandShake is success");
		session.writeTextMessage(responseMessage);

	}

}
