package vestige.module.impl.render;

import cr.launcher.Config;
import vestige.module.Category;
import vestige.module.ListeningType;
import vestige.module.Module;

public class Fullbright extends Module {

	public Fullbright() {
		super("Fullbright", Category.RENDER, ListeningType.NEVER);
	}
	
	public void onEnable() {
		Config.getGameSettings().y = 100;
	}
	
	public void onDisable() {
		Config.getGameSettings().y = 1;
	}

}
