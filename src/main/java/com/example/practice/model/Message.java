package com.example.practice.model;

import org.springframework.data.annotation.Id;

public class Message {

	@Id
	private String id;
	private String messageText;
	
	public Message(String id, String messageText) {
		super();
		this.id = id;
		this.messageText = messageText;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	
}
