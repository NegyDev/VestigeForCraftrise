package vestige.event.impl;

import vestige.event.Event;

public class EventKeyPressed extends Event {
	
	private int key;
	
	public EventKeyPressed(int key) {
		super(false);
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}
	
}