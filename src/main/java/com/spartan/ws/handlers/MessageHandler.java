package com.spartan.ws.handlers;

import io.vertx.core.http.ServerWebSocket;

public interface MessageHandler {

	public void processMessage(ServerWebSocket session, String message);

}
