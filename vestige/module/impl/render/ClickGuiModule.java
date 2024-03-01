package vestige.module.impl.render;

import org.lwjgl.input.Keyboard;

import cr.launcher.Config;
import vestige.Vestige;
import vestige.event.Event;
import vestige.event.impl.EventRender;
import vestige.event.impl.EventUpdate;
import vestige.module.Category;
import vestige.module.ListeningType;
import vestige.module.Module;
import vestige.setting.impl.ModeSetting;
import vestige.ui.click.vestige.VestigeClickGUI;
import vestige.ui.click.vestige.VestigeRainbowClickGUI;
import vestige.util.misc.TimerUtil;

public class ClickGuiModule extends Module {
	
	private ModeSetting mode = new ModeSetting("Mode", "Vestige", "Vestige", "Vestige Rainbow");
	
	private TimerUtil timer = new TimerUtil();
	
	public ClickGuiModule() {
		super("ClickGUI", Category.RENDER, Keyboard.KEY_RSHIFT);
		this.addSettings(mode);
	}
	
	public void onEnable() {
		switch(mode.getMode()) {
		case "Vestige":
			Config.getMinecraft().a(new VestigeClickGUI(),5L);
			break;
		case "Vestige Rainbow":
			Config.getMinecraft().a(new VestigeRainbowClickGUI(),5L);
			break;
		}
	}
	
	public void onEvent(Event e) {
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			Config.getMinecraft().a((com.craftrise.client.dG)null,5L);
		}
	}
	
	private void handleRotations() {
		final double speed = 0.15F;
		
		
		timer.reset();
	}

}
