package com.example.websocketdemo.model;

import com.example.websocketdemo.model.ChatMessage.MessageType;

public class ChatImage {

	 private MessageType type;
	    private Object content;
	    private String sender;

	    public enum MessageType {
	        CHAT,
	        JOIN,
	        LEAVE
	    }

	    public MessageType getType() {
	        return type;
	    }

	    public void setType(MessageType type) {
	        this.type = type;
	    }

	    public Object getContent() {
	        return content;
	    }

	    public void setContent(Object content) {
	        this.content = content;
	    }

	    public String getSender() {
	        return sender;
	    }

	    public void setSender(String sender) {
	        this.sender = sender;
	    }
	    
}
