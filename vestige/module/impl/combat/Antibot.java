package vestige.module.impl.combat;

import java.lang.reflect.Method;
import java.util.ArrayList;

import com.craftrise.gk;
import com.craftrise.iF;
import com.craftrise.m9;
import com.craftrise.mj;

import cr.launcher.Config;
import cr.launcher.main.a;
import vestige.Vestige;
import vestige.event.Event;
import vestige.event.impl.EventMotionUpdate;
import vestige.event.impl.EventReceivePacket;
import vestige.event.impl.EventUpdate;
import vestige.module.Category;
import vestige.module.ListeningType;
import vestige.module.Module;
import vestige.setting.impl.BooleanSetting;
import vestige.setting.impl.NumberSetting;

public class Antibot extends Module {
	
	private NumberSetting ticksExisted = new NumberSetting("Ticks Existed", 40, 0, 200, 5, this);
	private BooleanSetting invisibleOnSpawn = new BooleanSetting("Invisible on spawn", true, this);
	private BooleanSetting hycraft = new BooleanSetting("Craftrise", false, this);
	
	private ArrayList<com.craftrise.mj> blacklistedEntities = new ArrayList<>();
	
	public Antibot() {
		super("Antibot", Category.COMBAT, ListeningType.ALWAYS);
		this.addSettings(ticksExisted, invisibleOnSpawn, hycraft);
	}
	public static void RemoveEntity(Object entity) {
        try {
            Class<?> worldClass = Class.forName("com.craftrise.client.cf");
            Method bMethod = worldClass.getDeclaredMethod("b", com.craftrise.m9.class, long.class);
            bMethod.invoke(Config.getMinecraft().bu, entity, 5L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void onEvent(Event event) {
		if(a.q.Z >= 5 && !this.isEnabled()) {
			return;
		}
		if(event instanceof EventUpdate) {
			if(a.q.Z < 5) {
				blacklistedEntities.clear();
			}
		} else if(event instanceof EventMotionUpdate) {
			if(a.q.Z > 300) {
				if(hycraft.isEnabled()) {
					for (Object entity : Config.getMinecraft().bu.g) {
		                if (entity instanceof com.craftrise.m9) {
		                   com.craftrise.m9 minecraftEntity = (com.craftrise.m9) entity;
		                   boolean isbot = isBot(minecraftEntity);
		                   if(isbot == true) {
		                	    Vestige.addChatMessage("Detected a bot : Craftrise antibot");
		                	    blacklistedEntities.add((mj) minecraftEntity);
		                	    Vestige.addChatMessage("Entity added to blacklist");
		                   }else {
		                	   
		                   }
				          
		                }
					}
				}
			}
		}
	}
	public boolean isBot(m9 Entity) {
		if(Entity.E() && Entity != a.q &&Entity.Z < 10) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean canAttack(com.craftrise.mj e) {
		if(invisibleOnSpawn.isEnabled()) {
			if(e.Z < 10) {
				blacklistedEntities.add(e);
				Vestige.addChatMessage("Detected a bot : invisible on spawn antibot");
				return false;
			}
		}
		
		if(a.q.Z < ticksExisted.getValue()) {
			return false;
		}
		
		if(blacklistedEntities.contains(e)) {
			return false;
		}
		
		return true;
	}

}