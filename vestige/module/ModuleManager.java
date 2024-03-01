package vestige.module;

import java.util.ArrayList;

import vestige.module.impl.combat.Antibot;
import vestige.module.impl.combat.Criticals;
import vestige.module.impl.combat.Killaura;
import vestige.module.impl.exploit.Xray;
import vestige.module.impl.movement.Longjump;
import vestige.module.impl.movement.Strafe;
import vestige.module.impl.player.Cheststealer;
import vestige.module.impl.player.Nofall;
import vestige.module.impl.render.*;

public class ModuleManager {
	
	public static  ArrayList<Module> modules = new ArrayList<>();
	
	public ModuleManager() {
		//Combat
		modules.add(new Antibot());
		modules.add(new Killaura());
		modules.add(new Criticals());
		
		
		//Movement
		modules.add(new Strafe());
		modules.add(new Longjump());
		
		//Player
		modules.add(new Nofall());
		modules.add(new Cheststealer());
		
		//World
		
		//Render
		modules.add(new ClickGuiModule());
		modules.add(new HUD());
		modules.add(new Chams());
		modules.add(new Fullbright());
		
		//Exploit
		modules.add(new Xray());
		
		//Ghost
		
		//Misc
	}

	public ArrayList<Module> getModules() {
		return modules;
	}
	
	public Module getModuleByName(String name) {
		for(Module m : modules) {
			if(m.getName().equals(name)) {
				return m;
			}
		}
		return null;
	}
	
}