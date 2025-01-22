package com.spartan.ws.message;

public class ResponseMessage<T> {

	private String msgId;
	private T payload;

	public ResponseMessage(String string, T payload) {
		this.msgId = string;
		this.payload = payload;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EHBMessage [msgId=");
		builder.append(msgId);
		builder.append(", payload=");
		builder.append(payload);
		builder.append("]");
		return builder.toString();
	}

}
