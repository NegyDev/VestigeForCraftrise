package net.minecraft.client.gui;
import com.craftrise.client.y;
import cr.launcher.Config;

import java.lang.reflect.Field;

public class ScaledResolution {
    public y ScaledResulation;
    public ScaledResolution(net.minecraft.client.Minecraft Minecraft){
        ScaledResulation = new y(Config.getMinecraft());
    }

    public int getScaledWidth() {
        try {
            Class<?> resulationClass = ScaledResulation.getClass();
            Field getscaledwidthfield = resulationClass.getDeclaredField("d");
            getscaledwidthfield.setAccessible(true);
            return (int) getscaledwidthfield.get(ScaledResulation);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int getScaleFactor(){
        try {
            Class<?> resulationClass = ScaledResulation.getClass();
            Field getscaledwidthfield = resulationClass.getDeclaredField("a");
            getscaledwidthfield.setAccessible(true);
            return (int) getscaledwidthfield.get(ScaledResulation);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int getScaledHeight() {
        try {
            Class<?> resulationClass = ScaledResulation.getClass();
            Field getscaledwidthfield = resulationClass.getDeclaredField("b");
            getscaledwidthfield.setAccessible(true);
            return (int) getscaledwidthfield.get(ScaledResulation);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
