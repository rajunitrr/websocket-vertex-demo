package com.vertex.ws.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vertex.ws.message.ResponseMessage;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageHandlerUtil {

	private Map<String, MessageHandler> handlers = new HashMap<String, MessageHandler>();

	public void registerHandlers(String key, MessageHandler messageHandler) {

		handlers.put(key, messageHandler);

	}

	public MessageHandler getHandler(String msgId) {
		return handlers.get(msgId);
	}

	public String buildMessage(String messageId, Object message) {

		try {
			ResponseMessage<Object> msgInfo = new ResponseMessage<Object>(messageId, message);
			return new ObjectMapper().writeValueAsString(msgInfo);
		} catch (Exception e) {
			log.error("MHU::Exception at buildMessage " + e.getLocalizedMessage());
		}
		return null;

	}
}