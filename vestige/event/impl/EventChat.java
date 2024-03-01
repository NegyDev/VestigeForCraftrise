package vestige.event.impl;

import vestige.event.Event;

public class EventChat extends Event {
	
	private String message;
	
	public EventChat(String message) {
		super(false);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}