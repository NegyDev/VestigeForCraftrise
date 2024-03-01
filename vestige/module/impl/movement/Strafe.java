package vestige.module.impl.movement;

import org.lwjgl.input.Keyboard;

import vestige.Mappings.ThePlayer;
import vestige.event.Event;
import vestige.event.impl.EventMotionUpdate;
import vestige.event.impl.EventRender;
import vestige.module.Category;
import vestige.module.Module;
import vestige.util.misc.TimerUtil;

public class Strafe extends Module{
    private boolean zýpladýkxd = false;
	TimerUtil timer = new TimerUtil();
	
	  public Strafe() {
		  super("Strafe", Category.MOVEMENT, Keyboard.KEY_X);
	    }

	
	public void onEvent(Event e) {
		if(e instanceof EventMotionUpdate) {
			 if (ThePlayer.isMoving() &&timer.hasReached(100)) {
		            if(ThePlayer.onGround()){
		                if (!zýpladýkxd) {
		                    ThePlayer.jump();
		                    zýpladýkxd = true;
		                    timer.reset();
		                }
		            }
		            ThePlayer.Strafe(0.435f);
		            zýpladýkxd = false;
		        } else {
		            zýpladýkxd = false;
		        }
			
		}
	}

}
