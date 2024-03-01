package vestige.module.impl.combat;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.craftrise.m9;
import com.craftrise.mj;
import com.craftrise.on;

import cr.launcher.BlockPos;
import cr.launcher.Config;
import cr.launcher.main.a;
import net.minecraft.util.MathHelper;
import vestige.Vestige;
import vestige.event.Event;
import vestige.event.impl.EventJump;
import vestige.event.impl.EventMotionUpdate;
import vestige.event.impl.EventPostMotionUpdate;
import vestige.event.impl.EventRender;
import vestige.event.impl.EventStrafing;
import vestige.event.impl.EventUpdate;
import vestige.module.Category;
import vestige.module.Module;
import vestige.setting.impl.BooleanSetting;
import vestige.setting.impl.ModeSetting;
import vestige.setting.impl.NumberSetting;
import vestige.util.misc.TimerUtil;

public class Killaura extends Module {
	
	public m9 target;
	public BlockPos targetPos;
	
	private ModeSetting rotations = new ModeSetting("Rotations", "Normal", "Normal", "Randomised", "Down", "None");
	private ModeSetting renderedRotations = new ModeSetting("Rendered Rots", "Normal", "Normal", "Smooth");
	private NumberSetting aps = new NumberSetting("APS", 10, 1, 20, 1, this);
	private NumberSetting range = new NumberSetting("Range", 4, 3, 6, 0.1, this);
	private NumberSetting startingRange = new NumberSetting("Starting Range", 4, 3, 6, 0.1, this);
	private ModeSetting attackTiming = new ModeSetting("Attack Timing", "Pre", "Pre", "Render");
	private ModeSetting autoblock = new ModeSetting("Autoblock", "Fake", "Vanilla", "NCP", "Hypixel", "Redesky", "Fake", "None");
	private BooleanSetting keepSprint = new BooleanSetting("Keep Sprint", true, this);
	public BooleanSetting moveFix = new BooleanSetting("Move Fix", false, this);
	public BooleanSetting backTrack = new BooleanSetting("BackTrack", false, this);
	
	public float yaw, pitch, smoothYaw, smoothPitch;
	
	private int autoblockTicks;
	
	private TimerUtil timer = new TimerUtil();
	private List<mj> targetEntities = new ArrayList<>();
	
	private boolean blocking;
	
	public Killaura() {
		super("Killaura", Category.COMBAT, Keyboard.KEY_R);
		this.addSettings(rotations, renderedRotations, aps, range, startingRange, attackTiming, autoblock, keepSprint, moveFix, backTrack);
	}
	
	public void onEnable() {
		smoothYaw = MathHelper.wrapAngleTo180_float(a.q.bL);
		smoothPitch = a.q.N;
		autoblockTicks = 0;
	}
	
	public void onDisable() {
		target = null;
	}
	
	public void onEvent(Event event) {
		if(a.q.Z < 2) {
			this.setEnabled(false);
			return;
		}
		
		long randomDelay = (long) (Math.random() * 100 - 20);
		
		boolean attackTick = false;
		
		if(event instanceof EventRender && attackTiming.is("Render")) {
			attackTick = target != null && timer.hasReached((long) (1000 / aps.getValue())) && a.q.Z % 5 != 0 && a.q.Z % 17 != 0 && timer.getTimeElapsed() > 20;
			
			if(a.q.Z % 2 == 0) {
				attackTick = false;
			}
		} else if(event instanceof EventMotionUpdate && attackTiming.is("Pre")) {
			attackTick = target != null && timer.hasReached((long) (1000 / aps.getValue() + Math.random() * 15 - 7)) && a.q.Z % 5 != 0 && a.q.Z % 17 != 0;
		}
		
		if(target != null) {
			//autoblock(event, attackTick);
		}
		
		if(event instanceof EventMotionUpdate) {
			EventMotionUpdate e = (EventMotionUpdate) event;
			 List<com.craftrise.mj> targetEntities = getEntities();
		        if (!targetEntities.isEmpty()) {
		            Collections.sort(targetEntities, new Comparator<mj>() {
		                @Override
		                public int compare(com.craftrise.mj entity1, com.craftrise.mj entity2) {
		                    double distance1 = GetDistanceToEntity(entity1);
		                    double distance2 = GetDistanceToEntity(entity2);
		                    return Double.compare(distance1, distance2);
		                }
		            });

		            target = targetEntities.get(0);
			
		}
		
		if(attackTick) {
			if(keepSprint.isEnabled()) {
				a.q.z.a(new com.craftrise.v(),5L);
				a.q.z.a(new on(target, getAttackEnum()),5L);
				a.q.z.a(new on(target, getAttackEnum()),5L);
			} else {
				a.q.z.a(new com.craftrise.v(),5L);
				a.q.z.a(new on(target, getAttackEnum()),5L);
				a.q.z.a(new on(target, getAttackEnum()),5L);
			}
			timer.reset();
		}
		}
	}
	 private List<com.craftrise.mj> getEntities() {
	        List<com.craftrise.mj> entities = new ArrayList<>();

	        for (final Object o : Config.getMinecraft().bu.H) {
	            final com.craftrise.mj entity = (com.craftrise.mj) o;
	            if (entity == null) continue;

	            double distance = GetDistanceToEntity(entity);

	            if (!entity.E() && distance <= 7 && a.q.e(entity, 5L) && entity != a.q && entity.Z > 40) {
	                entities.add(entity);
	            }
	        }

	        return entities;
	    }
	 
	public static on.a getAttackEnum() {
	    try {
	        Field field = on.a.class.getDeclaredField("ATTACK");
	        field.setAccessible(true);
	        return (on.a) field.get(null);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	
	private void autoblock(Event e, boolean attackTick) {
		switch(autoblock.getMode()) {
		case "Vanilla":
			if(e instanceof EventUpdate) {
				//PacketUtils.sendBlocking(false, false);
			}
			break;
		case "NCP":
			if(attackTick) {
				//PacketUtils.releaseUseItem(false);
				blocking = false;
			} else if(e instanceof EventPostMotionUpdate) {
				if(!blocking) {
					//PacketUtils.sendBlocking(false, false);
					blocking = true;
					autoblockTicks = 0;
				}
				autoblockTicks++;
			}
			break;
		case "Hypixel":
			/*
			if(!Vestige.getModuleManager().getModuleByName("Speed").isEnabled()) {
				if(e instanceof EventPostMotionUpdate) {
					if(a.q.Z % 3 == 0) {
						PacketUtils.releaseUseItem(false);
						blocking = false;
					} else if(!blocking) {
						mc.playerController.interactWithEntitySendPacket(mc.thePlayer, target);
						PacketUtils.sendBlocking(false, true);
					}
				}
			}
			*/
			if(attackTick) {
				//PacketUtils.releaseUseItem(false);
			} else if(e instanceof EventPostMotionUpdate) {
				if(a.q.Z % 3 == 0) {
					//PacketUtils.sendBlocking(false, false);
				}
			}
			break;
		case "Redesky":
			if(e instanceof EventMotionUpdate) {
				//PacketUtils.releaseUseItem(false);
				//mc.playerController.interactWithEntitySendPacket(mc.thePlayer, target);
				//PacketUtils.sendBlocking(false, false);
				blocking = true;
			} else if(e instanceof EventPostMotionUpdate) {
				
			}
			break;
		}
	}
	
	private void releaseBlocking() {
		//CombatProcessor.setBlocking(blocking = false);
		switch(autoblock.getMode()) {
		case "Vanilla":
			//PacketUtils.releaseUseItem(5);
			break;
		case "NCP":
		case "Hypixel":
		case "Redesky":
			//PacketUtils.releaseUseItem(false);
			break;
		}
	}
	
	private double getDistance() {
		if(target != null) {
			return GetDistanceToEntity(target);
		} else {
			return Float.NaN;
		}
	}
	public static double GetDistanceToEntity(com.craftrise.m9 m92) {
        try {
            double f2 = (a.q.bE- m92.bE);
            double f3 = (a.q.aY - m92.aY);
            double f4 = (a.q.bH - m92.bH);
            double result = Math.sqrt(f2 * f2 + f3 * f3 + f4 * f4);
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
            return -1;
        }

    }
	
	private void updateRotations() {
		if(target != null) {
			switch(rotations.getMode()) {
			case "Normal":
				normalRotations();
				break;
			case "Randomised":
				randomisedRotations();
				break;
			case "Redesky":
				RedeskyRotations();
				break;
			case "Verus":
				VerusRotations();
				break;
			case "Down":
				DownRotations();
				break;
			}
			
			this.yaw = Math.round(this.yaw * 1000) / 1000;
			this.pitch = Math.round(this.pitch * 1000) / 1000;
			
			if(rotations.is("None")) {
				this.yaw = a.q.bL;
				this.pitch = a.q.N;
			}
		}
	}
	
	private void normalRotations() {
		float yaw = (float) (getRotations()[0] + Math.random() - 0.5);
		float pitch = (float) (getRotations()[1] + Math.random() - 0.5);
		
		if(pitch > 90.0) {
			pitch = 90;
		} else if(pitch < -90.0) {
			pitch = -90;
		}
		
		this.yaw = yaw;
		this.pitch = pitch;
	}
	
	private void randomisedRotations() {
		float yaw = (float) (getRotations()[0] + Math.random() - 0.5);
		float pitch = (float) (getRotations()[1] + Math.random() - 0.5);
		
		if(pitch > 90.0) {
			pitch = 90;
		} else if(pitch < -90.0) {
			pitch = -90;
		}
		
		if(getDistance() > 0.8) {
			if((Math.abs(this.yaw - yaw) > 10 && Math.abs(this.yaw - yaw) < 350) || (Math.abs(this.pitch - pitch) > 15 && Math.abs(this.pitch - pitch) < 345)) {
				this.yaw = yaw;
				this.pitch = pitch;
			}
		} else {
			if(getDistance() > 0.5 && Math.abs(this.yaw - yaw) > 60 && Math.abs(this.yaw - yaw) < 300) {
				this.yaw = yaw;
			}
			this.pitch = 90;
		}
	}
	
	private void RedeskyRotations() {
		if(getDistance() < 1.3) {
			this.yaw = a.q.bL;
			this.pitch = 90;
		} else {
			normalRotations();
			this.yaw = a.q.bL;
			this.yaw = (float) (Math.random() * 360) - 180;
			this.pitch = (float) (Math.random() * 360) - 180;
		}
	}
	
	private void VerusRotations() {
		
	}
	
	private void DownRotations() {
		float yaw = (float) (getRotations()[0] + Math.random() - 0.5);
		float pitch = 90;

		if(Math.abs(this.yaw - yaw) > 10 && Math.abs(this.yaw - yaw) < 350) {
			this.yaw = yaw;
		}
		this.pitch = pitch;
	}
	
	private void rotate(EventMotionUpdate e) {
		e.setYaw(yaw);
		e.setPitch(pitch);
		
		if(renderedRotations.is("Normal")) {
			a.q.a = yaw;
			a.q.ap = yaw;
		} else if(renderedRotations.is("Smooth")) {
			float yaw = getRotations()[0];
			float pitch = getRotations()[1];
			
			double yawTurnSpeed = 30;
			double mult = 0.4;
			
			if(Math.abs(yaw - smoothYaw) < 60) {
				if(smoothYaw > yaw) {
					smoothYaw -= (smoothYaw - yaw) * mult;
				} else {
					smoothYaw += (yaw - smoothYaw) * mult;
				}
			} else if(Math.abs(yaw - smoothYaw) > 360 - 60) {
				if(smoothYaw > yaw) {
					smoothYaw += (360 - (smoothYaw - yaw)) * mult;
				} else {
					smoothYaw -= (360 - (yaw - smoothYaw)) * mult;
				}
			} else {
				if(Math.abs(yaw - smoothYaw) < 180) {
					if(smoothYaw > yaw) {
						smoothYaw -= yawTurnSpeed;
					} else {
						smoothYaw += yawTurnSpeed;
					}
				} else {
					if(smoothYaw > yaw) {
						smoothYaw += yawTurnSpeed;
					} else {
						smoothYaw -= yawTurnSpeed;
					}
				}
			}
			
			double pitchTurnSpeed = 15;
			
			if(Math.abs(pitch - smoothPitch) < 30) {
				if(smoothPitch > pitch) {
					smoothPitch -= (smoothPitch - pitch) * mult;
				} else {
					smoothPitch += (pitch - smoothPitch) * mult;
				}
			} else {
				if(Math.abs(pitch - smoothPitch) < 180) {
					if(smoothPitch > pitch) {
						smoothPitch -= pitchTurnSpeed;
					} else {
						smoothPitch += pitchTurnSpeed;
					}
				} else {
					if(smoothPitch > pitch) {
						smoothPitch += pitchTurnSpeed;
					} else {
						smoothPitch -= pitchTurnSpeed;
					}
				}
			}
			
			a.q.a = smoothYaw;
			a.q.ap = smoothYaw;
		}
	}
	
	private m9 getClosest() {
		m9 finalTarget = null;
		
		for(m9 e : Config.getMinecraft().bu.g) {
			if(canAttack(e)) {
				if(finalTarget == null) {
					finalTarget = e;
				} else {
					if(GetDistanceToEntity(e) < GetDistanceToEntity(finalTarget)) {
						finalTarget = e;
					}
				}
			}
		}
		return finalTarget;
	}
	  public float getEyeHeight(m9 Entity)
	    {
	        return Entity.t * 0.85F;
	    }
	
	public float[] getRotations() {
		double deltaX = target.bE + (target.bE - target.a6) - a.q.bE,
				deltaY = target.aY - 3.5 + getEyeHeight(target) - a.q.aY + getEyeHeight(a.q),
				deltaZ = target.bH + (target.bH - target.G) - a.q.bH,
				distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaZ, 2));

		float yaw = (float) Math.toDegrees(-Math.atan(deltaX / deltaZ)),
				pitch = (float) -Math.toDegrees(Math.atan(deltaY / distance));

		if(deltaX < 0 && deltaZ < 0) {
			yaw = (float) (90 + Math.toDegrees(Math.atan(deltaZ / deltaX)));
		}else if(deltaX > 0 && deltaZ < 0) {
			yaw = (float) (-90 + Math.toDegrees(Math.atan(deltaZ / deltaX)));
		}
		return new float[] {yaw, pitch};
	}
	
	private boolean canAttack(m9 e) {
		if(e != a.q) {
			if(e instanceof com.craftrise.mj) {
				Antibot antibot = (Antibot) Vestige.getModuleManager().getModuleByName("Antibot");
				if(antibot.isEnabled() && !antibot.canAttack((com.craftrise.mj) e)) {
					return false;
				}
				
				if(this.target != null ? GetDistanceToEntity(e) <= range.getValue() : GetDistanceToEntity(e) <= startingRange.getValue()&&a.q.e(e, 5L)&&!e.E()) {
					if(e instanceof com.craftrise.mg) {
						com.craftrise.mg player = (com.craftrise.mg) e;
						return true;
					}
					return false;
				}
			}
		}
		return false;
	}

}
