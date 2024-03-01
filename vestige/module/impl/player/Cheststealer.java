package vestige.module.impl.player;

import org.lwjgl.input.Keyboard;

import com.craftrise.client.e3;

import cr.launcher.Config;
import cr.launcher.main.a;
import vestige.event.Event;
import vestige.event.impl.EventMotionUpdate;
import vestige.event.impl.EventUpdate;
import vestige.module.Category;
import vestige.module.Module;
import vestige.setting.impl.BooleanSetting;
import vestige.setting.impl.NumberSetting;
import vestige.util.misc.TimerUtil;

public class Cheststealer extends Module {
	
	TimerUtil timer = new TimerUtil();
	
	public NumberSetting delay = new NumberSetting("Delay", 25, 0, 300, 10, this);
	public BooleanSetting autoClose = new BooleanSetting("Auto close", true, this);
	public BooleanSetting GuiDetect = new BooleanSetting("Gui Detect", true, this);

	public Cheststealer() {
		super("ChestStealer", Category.WORLD, Keyboard.KEY_N);
		this.addSettings(delay, autoClose, GuiDetect);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventMotionUpdate) {
			if((Config.getMinecraft().bw instanceof com.craftrise.client.e3)) {
				
				e3 chest = (e3) Config.getMinecraft().bw;

				for(int i = 0; i < 27; i++) {
						if(timer.hasReached((long) delay.getValue())) {
							Config.getMinecraft().b.a(chest.E.i, i, 0, 1, a.q, 5L);
					}

				}

			}
		}
	}

}
