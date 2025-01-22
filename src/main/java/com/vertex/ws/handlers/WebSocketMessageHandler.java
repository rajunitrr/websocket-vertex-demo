package com.vertex.ws.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vertex.ws.util.MessageConstants;

import io.vertx.core.http.ServerWebSocket;
import io.vertx.core.json.JsonObject;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WebSocketMessageHandler {

	@Autowired
	private MessageHandlerUtil msgHandlerUtil;

	public void handleSocket(ServerWebSocket socket) {
		socket.textMessageHandler(message -> handleTextMessage(socket, message));
		socket.closeHandler(v -> handleSocketClose(socket));
	}

	private void handleTextMessage(ServerWebSocket socket, String message) {
		try {
			String errorMessage = msgHandlerUtil.buildMessage(MessageConstants.WS_INVALID_MSGID, MessageConstants.WS_INVALID_MSG);

			JsonObject jsonMessage = new JsonObject(message);
			String msgId = jsonMessage.getString("msgId");

			log.info("msgId:"+msgId);
			
			if (msgId == null || msgId.isEmpty() || null == msgId) {
				socket.writeTextMessage(errorMessage);
				return;
			}
			
			
			MessageHandler handler = msgHandlerUtil.getHandler(msgId);
			if (handler != null) {
				handler.processMessage(socket, message);
			} else {
				socket.writeTextMessage(errorMessage);
			}
		} catch (Exception e) {
			log.error("Exception :: "+e.getLocalizedMessage());
		}
	}

	private void handleSocketClose(ServerWebSocket socket) {
		System.out.println("Connection closed: " + socket.remoteAddress());
	}
}
