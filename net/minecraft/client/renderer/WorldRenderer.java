package net.minecraft.client.renderer;
import com.craftrise.client.ed;
import net.minecraft.client.renderer.vertex.VertexFormat;

import java.nio.FloatBuffer;

public class WorldRenderer extends ed{
    public WorldRenderer(int i) {
        super(i);
    }
    private void growBuffer(int p_181670_1_){
        super.a(p_181670_1_);
    }
    public void sortVertexData(float p_181674_1_, float p_181674_2_, float p_181674_3_){
        c(p_181674_1_,p_181674_2_,p_181674_3_);
    }
    public void endVertex(){
        super.f(5L);
    }
    public void reset(){
        e();
    }
    public WorldRenderer color(float red, float green, float blue, float alpha)
    {
        return this.color((int)(red * 255.0F), (int)(green * 255.0F), (int)(blue * 255.0F), (int)(alpha * 255.0F));
    }
    public void begin(int glMode, VertexFormat format){
        super.a(glMode,format,5L);
    }
    public WorldRenderer pos(double x, double y, double z){
        try {
            return (WorldRenderer)ed.class.getMethod("a").invoke(null);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
