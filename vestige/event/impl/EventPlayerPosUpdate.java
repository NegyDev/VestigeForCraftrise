package vestige.event.impl;

import com.craftrise.mg;
import vestige.event.Event;

public class EventPlayerPosUpdate extends Event {
	
	private final mg player;

	public EventPlayerPosUpdate(mg p) {
		super(false);
		this.player = p;
	}
	
	public mg getPlayer() {
		return player;
	}

}