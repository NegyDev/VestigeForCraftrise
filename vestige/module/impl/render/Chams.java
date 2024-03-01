package vestige.module.impl.render;

import org.lwjgl.opengl.GL11;

import vestige.event.Event;
import vestige.event.impl.EventPostRenderPlayer;
import vestige.event.impl.EventRenderPlayer;
import vestige.module.Category;
import vestige.module.Module;

public class Chams extends Module {

	public Chams() {
		super("Chams", Category.RENDER);
	}
	
	public void onEvent(Event event) {
		if(event instanceof EventRenderPlayer) {
			GL11.glEnable(32823);
            GL11.glPolygonOffset(1.0F, -1100000.0F);
		} else if(event instanceof EventPostRenderPlayer) {
			GL11.glDisable(32823);
            GL11.glPolygonOffset(1.0F, 1100000.0F);
		}
	}
	
}