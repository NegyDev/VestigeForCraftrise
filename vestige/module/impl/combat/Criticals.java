package vestige.module.impl.combat;

import com.craftrise.lE;
import com.craftrise.m9;
import com.craftrise.mg;
import com.craftrise.on;
import com.mojang.realmsclient.gui.ChatFormatting;

import cr.launcher.main.a;
import vestige.Vestige;
import vestige.event.Event;
import vestige.event.impl.EventMotionUpdate;
import vestige.event.impl.EventSendPacket;
import vestige.module.Category;
import vestige.module.Module;
import vestige.setting.impl.ModeSetting;

public class Criticals extends Module {
	
	public ModeSetting mode = new ModeSetting("Mode", "Packet", "Packet", "Edit", "Hover", "NoGround");
	
	private int counter;
	private double y;
	
	public Criticals() {
		super("Criticals", Category.COMBAT);
		this.addSettings(mode);
	}
	
	public void onEvent(Event event) {
		if(event instanceof EventMotionUpdate) {
			this.setDisplayName(this.getName() + " " + ChatFormatting.GRAY + mode.getMode());
			EventMotionUpdate e = (EventMotionUpdate) event;
			if(mode.is("NoGround") && Vestige.getModuleManager().getModuleByName("Killaura").isEnabled() && ((Killaura) Vestige.getModuleManager().getModuleByName("Killaura")).target != null && !Vestige.getModuleManager().getModuleByName("Fly").isEnabled()) {
				e.setOnGround(!a.q.s.a(5L) && a.q.aT.b(5L) >= 0 && a.q.aT.b(5L) <= 0.16);
			}
			
			if(mode.is("Hover")) {
				double ypos = a.q.aY;
	    		if(a.q.s.a(5L)) {
	    			e.setOnGround(false);
	    			if(counter == 0){
	    				y = ypos + 1E-8;
	    				e.setOnGround(true);
	    			} else if(counter == 1) {
	    				y -= 5E-15;
	    			} else {
	    				y -= 4E-15;
	    			}
	    			
	    			if(y <= a.q.aY){
	    				counter = 0;
	    				y = a.q.aY;
	    				e.setOnGround(true);
	    			}
	    			e.setY(y);
	    			counter++;
	    		} else {
	    			counter = 0;
	    		}
			}
			
			if(mode.is("Edit")) {
				if(Vestige.getModuleManager().getModuleByName("Killaura").isEnabled() && ((Killaura) Vestige.getModuleManager().getModuleByName("Killaura")).target != null) {
					m9 entity = ((Killaura) Vestige.getModuleManager().getModuleByName("Killaura")).target;
					if(entity instanceof mg) {
						mg target = (mg) entity;
						
					EditCrits(e, target);
					}
				}
			}
		} else if(event instanceof EventSendPacket) {
			EventSendPacket e = (EventSendPacket) event;
			if(e.getPacket() instanceof on) {
				on packet = (on) e.getPacket();
					if(mode.is("Packet") && a.q.s.a(5L)) {
						a.q.z.a(new lE.a(a.q.bE, a.q.aY + 1E-4, a.q.bH, false),5L);
						a.q.z.a(new lE.a(a.q.bE, a.q.aY + 1E-6, a.q.bH, false),5L);
				}
			}
		}
	}
	
	private void hypixelEditCrits(EventMotionUpdate e, mg target) {
		if(a.q.s.a(5L)) {
			//0.41999998688698, 0.7531999805212, 1.00133597911215, 1.166109260938214, 1.24918707874468, 1.170787077218804, 1.015555072702206, 0.78502770378924, 0.4807108763317, 0.10408037809304
			if(target.a5 == 2) {
				e.setY(e.getY() + 0.0625E-4);
				e.setOnGround(false);
			} else if(target.a5 == 0) {
				e.setY(0);
				e.setOnGround(false);
			}
		}
	}
	
	private void EditCrits(EventMotionUpdate e, mg target) {
		if(target.a5 < 5) {
			e.setOnGround(true);
		} else if(target.a5 < 3) {
			e.setY(e.getY() + 0.01);
			e.setOnGround(false);
		} else {
			e.setY(e.getY() + 1E-5);
			e.setOnGround(false);
		}
	}
	
}