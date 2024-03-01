package vestige.event.impl;

import vestige.event.Event;

public class EventReach extends Event {
	
	private double reach;
	
	public EventReach(double reach) {
		super(false);
		this.reach = reach;
	}

	public double getReach() {
		return reach;
	}

	public void setReach(double reach) {
		this.reach = reach;
	}

}
