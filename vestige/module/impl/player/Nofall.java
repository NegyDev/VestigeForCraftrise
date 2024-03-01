package vestige.module.impl.player;

import com.mojang.realmsclient.gui.ChatFormatting;

import cr.launcher.main.a;
import vestige.Vestige;
import vestige.event.Event;
import vestige.event.impl.EventMotionUpdate;
import vestige.module.Category;
import vestige.module.Module;
import vestige.setting.impl.ModeSetting;

public class Nofall extends Module {
	
	private ModeSetting mode = new ModeSetting("Mode", "Edit", "Edit", "Hypixel", "Redesky", "Packet");
	
	private double currentFallDistance;
	private double ticksSpoofedGround;
	private boolean blinking;
	
	public Nofall() {
		super("Nofall", Category.PLAYER);
		this.addSettings(mode);
	}
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		if(blinking) {
			
			blinking = false;
		}
	}
	
	public void onEvent(Event event) {
		if(event instanceof EventMotionUpdate) {
			this.setDisplayName(this.getName() + " " + ChatFormatting.GRAY + mode.getMode());
			
			EventMotionUpdate e = (EventMotionUpdate) event;
			
			if(a.q.s.a(5L)) {
				currentFallDistance = 0;
				ticksSpoofedGround = 0;
			} else {
				if(a.q.aT.b(5L) < 0) {
					currentFallDistance += -a.q.aT.b(5L);
				}
			}
			
			switch(mode.getMode()) {
			case "Edit":
				if(currentFallDistance >= 3) {
					e.setOnGround(true);
					currentFallDistance = 0;
				}
				if(blinking) {
					
					blinking = false;
				}
				break;
			case "Redesky":
				if(currentFallDistance >= 2 && ticksSpoofedGround < 6) {
					e.setOnGround(true);
					currentFallDistance = 0;
					ticksSpoofedGround++;
				}
				if(blinking) {
					
					blinking = false;
				}
				break;
			case "Packet":
				if(currentFallDistance >= 2) {
					a.q.z.a(new com.craftrise.lE(true),5L);
					currentFallDistance = 0;
				}
				if(blinking) {
					
					blinking = false;
				}
				break;
			case "NCP":
				if(a.q.s.a(5L)) {
					if(blinking) {
						
						blinking = false;
					}
				} else if(currentFallDistance > 0) {
					e.setOnGround(true);
					//Vestige.getPacketsProcessor().setBlinking(true);
					blinking = true;
				}
				break;
			case "Hypixel":
				if(currentFallDistance > 3) {
					e.setOnGround(true);
					currentFallDistance = 0;
				}
				
				if(currentFallDistance > 1 && currentFallDistance < 2) {
					if(blinking) {
						//
						blinking = false;
					}
				} else {
					//Vestige.getPacketsProcessor().setBlinking(true);
					blinking = true;
				}
				break;
			}
		}
	}

}