package vestige;
import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import com.craftrise.client.dt;

import cr.launcher.Config;
import vestige.event.impl.EventMotionUpdate;
import vestige.event.impl.EventRender;
import vestige.event.impl.EventUpdate;
import vestige.module.Module;
import vestige.ui.click.vestige.VestigeClickGUI;
public class GuiIngameHook extends dt{

	public GuiIngameHook(dt Gui) {
		super(Config.getMinecraft());
	}
	public void a(float var1_1, long var2_2) {
		super.a(var1_1,var2_2);
		(new EventRender(var1_1)).call();
		Module.KeyCheckEvent();
	}

}
