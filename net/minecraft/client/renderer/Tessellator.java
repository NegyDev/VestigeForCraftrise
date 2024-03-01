package net.minecraft.client.renderer;
import com.craftrise.client.gK;

public class Tessellator extends gK{
    public WorldRenderer worldRenderer;
    private static final Tessellator instance = new Tessellator(2097152);
    public Tessellator(int i) {
        super(i);
        this.worldRenderer = new WorldRenderer(i);
    }
    public static Tessellator getInstance()
    {
        return instance;
    }
    public WorldRenderer getWorldRenderer() {
        return this.worldRenderer;
    }
    public void draw(){
        super.a(5L);
    }
}
