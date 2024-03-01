package vestige.event;

import vestige.Vestige;
import vestige.util.base.BaseUtil;

public class Event implements BaseUtil {
	
	private boolean cancelled;
	private boolean canCallOutOfGame;
	
	public Event(boolean canCallOutOfGame) {
		this.canCallOutOfGame = canCallOutOfGame;
	}
	
	public void call() {
		if(Vestige.GetPlayer() != null || canCallOutOfGame) {
			EventHandler.onEvent(this);
		}
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
	
	public boolean canCallOutOfGame() {
		return canCallOutOfGame;
	}
	
}