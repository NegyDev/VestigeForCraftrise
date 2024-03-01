package net.minecraft.client.gui;
import com.craftrise.client.dh;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import cr.launcher.Config;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import com.craftrise.client.gK;
import com.craftrise.client.ed;
import com.craftrise.client.gO;

public class Gui extends dh{
	public float zLevel = this.d;
	
    public static void drawHorizontalLine(float startX, float endX, float y, int color){
        if (endX < startX)
        {
        	float i = startX;
            startX = endX;
            endX = i;
        }

        drawRect(startX, y, endX + 1, y + 1, color);
    }
    public static void drawVerticalLine(float x, float startY, float endY, int color)
    {
        if (endY < startY)
        {
        	float i = startY;
            startY = endY;
            endY = i;
        }

        drawRect((double)x, (double)startY + (double)1, (double)x + (double)1, (double)endY, (int)color);
    }
    public static gK getTesellatorInstance() {
    	try {
    		return (gK)com.craftrise.client.gK.class.getMethod("a").invoke(Config.getMinecraft());
    	}catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    public static ed getWorldRenderer(gK Tesellerator) {
    	try {
    	    Field WorldRenderer = com.craftrise.client.gK.class.getDeclaredField("a");
    	    WorldRenderer.setAccessible(true);
    	    return (ed)WorldRenderer.get(Tesellerator);
    	}catch(Exception E) {
    		E.printStackTrace();
    		return null;
    	}
    }
    public static void pos(double x, double y, double z,ed WorldRendererOBJ) {
    	try {
    		com.craftrise.client.ed.class.getMethod("a", double.class,double.class,double.class).invoke(WorldRendererOBJ);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public static float getZLevel() {
        Gui guiInstance = new Gui();
        return guiInstance.zLevel;
    }
    public static void drawGradientRectSideways2(double x, double y, double width, double height, int startColor, int endColor) {
        drawGradientRectSideways(x, y, x + width, y + height, startColor, endColor);
    }

    public static void drawGradientRectSideways(double left, double top, double right, double bottom, int startColor, int endColor) {
        float f = (float) (startColor >> 24 & 255) / 255.0F;
        float f1 = (float) (startColor >> 16 & 255) / 255.0F;
        float f2 = (float) (startColor >> 8 & 255) / 255.0F;
        float f3 = (float) (startColor & 255) / 255.0F;
        float f4 = (float) (endColor >> 24 & 255) / 255.0F;
        float f5 = (float) (endColor >> 16 & 255) / 255.0F;
        float f6 = (float) (endColor >> 8 & 255) / 255.0F;
        float f7 = (float) (endColor & 255) / 255.0F;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(7425);
        gK tessellator = getTesellatorInstance();
        ed WorldRenderer = getWorldRenderer(tessellator);
        float zLevel = getZLevel();
        WorldRenderer.a(7, gO.k,5L);
        WorldRenderer.a((double)right, (double)top, (double)zLevel).a(f5, f6, f7, f4).f(5L);
        WorldRenderer.a((double)left, (double)top, (double)zLevel).a(f1, f2, f3, f).f(5L);
        WorldRenderer.a((double)left, (double)bottom, (double)zLevel).a(f1, f2, f3, f).f(5L);
        WorldRenderer.a((double)right, (double)bottom, (double)zLevel).a(f5, f6, f7, f4).f(5L);
        tessellator.a(5L);
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }
    
    public static void drawGradientRect2(int x, int y, int width, int height, int startColor, int endColor) {
        drawGradientRect((double)x, y, x + width, y + height, startColor, endColor);
    }
    public static void drawGradientRect(double left, double top, double right, double bottom, int startColor, int endColor) {
        float f = (float) (startColor >> 24 & 255) / 255.0F;
        float f1 = (float) (startColor >> 16 & 255) / 255.0F;
        float f2 = (float) (startColor >> 8 & 255) / 255.0F;
        float f3 = (float) (startColor & 255) / 255.0F;
        float f4 = (float) (endColor >> 24 & 255) / 255.0F;
        float f5 = (float) (endColor >> 16 & 255) / 255.0F;
        float f6 = (float) (endColor >> 8 & 255) / 255.0F;
        float f7 = (float) (endColor & 255) / 255.0F;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(7425);
        gK tessellator = getTesellatorInstance();
        ed WorldRenderer = getWorldRenderer(tessellator);
        float zLevel = getZLevel();
        WorldRenderer.a(7, gO.k,5L);
        WorldRenderer.a((double)right, (double)top, (double)zLevel).a(f1, f2, f3, f).f(5L);
        WorldRenderer.a((double)left, (double)top, (double)zLevel).a(f1, f2, f3, f).f(5L);
        WorldRenderer.a((double)left, (double)bottom, (double)zLevel).a(f5, f6, f7, f4).f(5L);
        WorldRenderer.a((double)right, (double)bottom, (double)zLevel).a(f5, f6, f7, f4).f(5L);
        tessellator.a(5L);
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }
    protected void drawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor)
    {
        float f = (float)(startColor >> 24 & 255) / 255.0F;
        float f1 = (float)(startColor >> 16 & 255) / 255.0F;
        float f2 = (float)(startColor >> 8 & 255) / 255.0F;
        float f3 = (float)(startColor & 255) / 255.0F;
        float f4 = (float)(endColor >> 24 & 255) / 255.0F;
        float f5 = (float)(endColor >> 16 & 255) / 255.0F;
        float f6 = (float)(endColor >> 8 & 255) / 255.0F;
        float f7 = (float)(endColor & 255) / 255.0F;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(7425);
        gK tessellator = getTesellatorInstance();
        ed WorldRenderer = getWorldRenderer(tessellator);
        WorldRenderer.a(7, gO.k,5L);
        float zLevel = getZLevel();
        WorldRenderer.a((double)right, (double)top, (double)this.zLevel).a(f1, f2, f3, f).f(5L);
        WorldRenderer.a((double)left, (double)top, (double)this.zLevel).a(f1, f2, f3, f).f(5L);
        WorldRenderer.a((double)left, (double)bottom, (double)this.zLevel).a(f5, f6, f7, f4).f(5L);
        WorldRenderer.a((double)right, (double)bottom, (double)this.zLevel).a(f5, f6, f7, f4).f(5L);
        tessellator.a(5L);
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void drawRect(double left, double top, double right, double bottom, int color){
        dh.a((int)left,(int)top,(int)right,(int)bottom,color,5L);
    }
    public static void drawCenteredString(FontRenderer fontRendererIn, String text, int x, int y, int color)
    {
        fontRendererIn.drawString(text, (int)(x - getStringWidth(text) / 2), (int)y, color);
    }
    public void drawString(com.craftrise.client.d0 fontRendererIn, String text, int x, int y, int color)
    {
        fontRendererIn.a(text, (float)x, (float)y, color,5L);
    }
    public static void drawModalRectWithCustomSizedTexture(int x, int y, float u, float v, int width, int height, float textureWidth, float textureHeight){
        dh.a(x,y,u,v,width,height,textureWidth,textureHeight,5L);
    }
    public static void drawScaledCustomSizeModalRect(int x, int y, float u, float v, int uWidth, int vHeight, int width, int height, float tileWidth, float tileHeight){
        dh.a(x,y,u,v,uWidth,vHeight,width,height,tileWidth,tileHeight,5L);
    }
    public static int getStringWidth(String s1) {
        try {
            Class<?> mcjClass = Config.getMinecraft().j.getClass();
            Method aMethod = mcjClass.getMethod("a", String.class);
            Object result = aMethod.invoke(Config.getMinecraft().j, s1);

            if (result instanceof Integer) {
                int intValue = (int) result;
                return intValue;
            } else {
                throw new IllegalStateException("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
