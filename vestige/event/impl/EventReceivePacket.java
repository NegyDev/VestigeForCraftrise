package vestige.event.impl;

import com.craftrise.lv;
import vestige.event.Event;

public class EventReceivePacket extends Event {
	
	private lv packet;

	public EventReceivePacket(lv packet) {
		super(false);
		this.packet = packet;
	}

	public lv getPacket() {
		return packet;
	}

	public void setPacket(lv packet) {
		this.packet = packet;
	}

}