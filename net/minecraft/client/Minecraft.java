package net.minecraft.client;

import cr.launcher.Config;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderManager;
import com.craftrise.client.gD;

import java.lang.reflect.Method;

import com.craftrise.client.fV;

public class Minecraft{

    private static Minecraft TheMinecraft;
    public FontRenderer fontRendererObj;
    public RenderManager renderManager;

    public Minecraft() {
        this.fontRendererObj = new FontRenderer(Config.getMinecraft().j);
        this.renderManager = new RenderManager(Minecraft.getMinecraft());
    }
    public static int getDebugFPS() {
        int fps = 31;

        try {
            Class<?> MinecraftClazz = Class.forName("com.craftrise.client.S");
            for (Method m : MinecraftClazz.getDeclaredMethods()) {
                if (m.getName().equals("b") && m.getParameterCount() == 0 && m.getReturnType().equals(int.class)) {
                    Object result = m.invoke(new com.craftrise.client.y(Config.getMinecraft()) );
                    fps = (int)result;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return fps;
    }

    public static Minecraft getMinecraft(){
        return TheMinecraft;
    }
    public gD getTextureManager() {
        try {
            return (gD)com.craftrise.client.S.class.getField("ax").get(Config.getMinecraft());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    public fV getResourceManager() {
        try {
            return (fV)com.craftrise.client.S.class.getField("ah").get(Config.getMinecraft());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(); 
            return null; 
        }
    }


    public static void init() {
        TheMinecraft = new Minecraft();
    }
    public void displayGuiScreen(GuiScreen guiScreenIn){
        Config.getMinecraft().a(guiScreenIn,5L);
    }
}
