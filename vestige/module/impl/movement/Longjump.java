package vestige.module.impl.movement;

import org.lwjgl.input.Keyboard;

import com.craftrise.dR;

import cr.launcher.BlockPos;
import cr.launcher.main.a;
import net.minecraft.util.MathHelper;
import vestige.Vestige;
import vestige.event.Event;
import vestige.event.impl.EventMotionUpdate;
import vestige.event.impl.EventReceivePacket;
import vestige.event.impl.EventRender;
import vestige.event.impl.EventSendPacket;
import vestige.event.impl.EventUpdate;
import vestige.event.impl.MovementEvent;
import vestige.module.Category;
import vestige.module.ListeningType;
import vestige.module.Module;
import vestige.module.impl.combat.Killaura;
import vestige.setting.impl.ModeSetting;

public class Longjump extends Module {
	
	private ModeSetting mode = new ModeSetting("Mode", "NCP", "NCP", "AAC");
	private ModeSetting aacMode = new ModeSetting("AAC Mode", "Minemora", "Minemora", "AAC4", "AAC4 Infinite", "skywars.com");
	
	
	private int counter, ticks;
	private boolean doneBoosting;
	private double speed;
	
	public Longjump() {
		super("Longjump", Category.MOVEMENT, ListeningType.ALWAYS, Keyboard.KEY_C);
		this.addSettings(mode, aacMode);
	}
	
	public void onEnable() {
		counter = 0;
		ticks = 0;
		if(mode.is("Hypixel")) {
			//DamageUtil.legitDamage();
			//Vestige.getPacketsProcessor().setBlinking(false);
		}
	}
	
	public void onDisable() {
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventRender) {
			aacMode.setShowed(mode.is("AAC"));
		}
		
		if(!isEnabled()) {
			return;
		}
		
		switch(mode.getMode()) {
		case "NCP":
			NCP(e);
			break;
		case "AAC":
			AAC(e);
			break;
		}
	}

	private void NCP(Event event) {
		if(event instanceof EventMotionUpdate) {
			EventMotionUpdate e = (EventMotionUpdate) event;
			if(a.q.s.a(5L)) {
				counter++;
			}
			if(counter > 1) {
				this.setEnabled(false);
				return;
			}
			
			if(!a.q.s.a(5L)) {
				if(a.q.aT.b(5L) >= 0.2 && a.q.aT.b(5L) < 0.4) {
					a.q.aT = new dR(a.q.aT.b(5L) + 0.01);
				} else if(a.q.aT.b(5L) >= 0) {
					//e.setMotionY(a.q.aT = e.getMotionY() + 0.005);
				} else if(a.q.aT.b(5L) >= -0.4) {
					a.q.aT = new dR(a.q.aT.b(5L) + 0.0455);
				} else {
					a.q.aT = new dR(a.q.aT.b(5L) + 0.016);
				}
			}
			
			/*
			if(e.getMotionY() >= 0.08) {
				e.setMotionY(e.getMotionY() + 0.005);
			} else if(e.getMotionY() < 0.08 && e.getMotionY() > -0.01) {
				e.setMotionY(e.getMotionY() + 0.05);
			} else if(e.getMotionY() < 0 && e.getMotionY() > -0.15) {
				e.setMotionY(e.getMotionY() + 0.0972);
			} else {
				e.setMotionY(e.getMotionY() + 0.11);
			}
			*/
		}
	}
	

	
	private void AAC(Event event) {
		if(event instanceof EventMotionUpdate) {
			EventMotionUpdate e = (EventMotionUpdate) event;
			if(aacMode.is("Minemora")) {
				if(a.q.s.a(5L)) {
					a.q.aT = new dR(a.q.aT.b(5L) + 0.42);
				} else {
					if(a.q.aT.b(5L) <= -0.08) {
						a.q.aT = new dR(a.q.aT.b(5L) + 0);
					}
				}
			}
		} else if(event instanceof EventMotionUpdate) {
			if(aacMode.is("AAC4 Infinite")) {
				if(a.q.s.a(5L)) {
					a.q.aT.d(0.03F);
					a.q.bh.d(1.04);
					a.q.bf.d(1.04);
				} else {
					AAC4Longjump();
				}
			} else if(aacMode.is("AAC4")) {
				if(counter > 0 && a.q.s.a(5L)) {
					this.setEnabled(false);
					return;
				}
				
				if(a.q.s.a(5L)) {
					doneBoosting = false;
					a.q.aT.b(0.2);
					
					counter++;
				} else {
					if(!doneBoosting) {
						a.q.aT.b(0.08);
						
						doneBoosting = true;
					} else {
					}
					
					AAC4Longjump();
				}
			} else if(aacMode.is("skywars.com")) {
				if(counter > 0 && a.q.s.a(5L)) {
					this.setEnabled(false);
					return;
				}
				
				if(a.q.s.a(5L)) {
					doneBoosting = false;
					a.q.aT.b(0.16);
					
					counter++;
				} else {
					if(!doneBoosting) {
						a.q.aT.b(0.08);
						
						doneBoosting = true;
					} else {
						if(a.q.aT.b(5L) > 0.1) {
							a.q.aT.b(0.055);
						} else {

						}
					}
				}
			}
		}
	}
	
	
	
	private void AAC4Longjump() {
		if(a.q.aT.b(5L) > 0) {
			if(a.q.aT.b(5L) > 0.2) {
				a.q.bh.d(1.017F);
				a.q.bf.d(1.017F);
			} else {
				a.q.bh.d(1.0112F);
				a.q.bf.d(1.0112F);
			}
			a.q.aT.b(0.03F);
		} else {
			a.q.aT.b(0.02F);
			if(a.q.aT.b(5L) < -0.6F) {
				if(a.q.bh.b(5L) > 0.05) {
					a.q.bh.b(0.027F);
				} else if(a.q.bh.b(5L) < -0.05) {
					a.q.bh.c(0.027F);
				}
				if(a.q.bf.b(5L) > 0.05) {
					a.q.bf.b(0.027F);
				} else if(a.q.bf.b(5L) < -0.05) {
					a.q.bf.c(0.027F);
				}
			} else {
				if(a.q.bh.b(5L) > 0.05) {
					a.q.bh.b(0.017F);
				} else if(a.q.bh.b(5L) < -0.05) {
					a.q.bh.c(0.017F);
				}
				if(a.q.bf.b(5L) > 0.05) {
					a.q.bf.a(0.017F);
				} else if(a.q.bf.b(5L) < -0.05) {
					a.q.bf.c(0.017F);
				}
			}
		}
	}

}
