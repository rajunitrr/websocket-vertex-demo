package com.vertex.ws.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vertex.ws.util.MessageConstants;

import io.vertx.core.http.ServerWebSocket;
import io.vertx.core.json.JsonObject;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WalletBalanceRequestHandler implements MessageHandler {

	@Autowired
	private MessageHandlerUtil msgUtil;

	@PostConstruct
	public void register() {

		msgUtil.registerHandlers(MessageConstants.WS_WALLET_BALANCE_REQUEST_HANDLER, this);

		log.info("Registered WalletBalanceRequestHandler");
	}

	@Override
	public void processMessage(ServerWebSocket session, String message) {
		
		JsonObject response = new JsonObject().put("msgId", 4)
				.put("status", "success");
		session.writeTextMessage(response.encode());

	}

}
