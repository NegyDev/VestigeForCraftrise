package vestige.event.impl;

import com.craftrise.m9;
import vestige.event.Event;

public class EventPostRenderPlayer extends Event {
	
	private m9 entity;
    private float partialTicks;

    public EventPostRenderPlayer(m9 entity, float partialTicks) {
    	super(false);
        this.entity = entity;
        this.partialTicks = partialTicks;
    }

    public m9 getEntity() {
        return entity;
    }

    public float getPartialTicks() {
        return partialTicks;
    }
	
}