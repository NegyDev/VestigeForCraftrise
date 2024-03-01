package vestige.event;

import vestige.Vestige;
import vestige.event.impl.EventChat;
import vestige.event.impl.EventKeyPressed;
import vestige.event.impl.EventReceivePacket;
import vestige.module.ListeningType;
import vestige.module.Module;

public class EventHandler {
	
	public static void onEvent(Event e) {
		if(e instanceof EventChat) {
			EventChat event = (EventChat) e;
			Vestige.getCommandManager().handleChat(event);
		}
		
		for(Module m : Vestige.getModuleManager().getModules()) {
			if(e instanceof EventKeyPressed) {
				EventKeyPressed event = (EventKeyPressed) e;
				
				if(m.getKeybind().getKey() == event.getKey()) {
					m.toggle();
				}
			}
			
			if((m.getListeningType() == ListeningType.ALWAYS || m.isEnabled()) && m.getListeningType() != ListeningType.NEVER) {
				m.onEvent(e);
			}
		}
		
		//AnticheatEventHandler.handle(e);
		handleProcessors(e);
	}
	
	private static void handleProcessors(Event e) {
		//Vestige.getPacketsProcessor().onEvent(e);
	}
	
}