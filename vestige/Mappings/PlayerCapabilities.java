package vestige.Mappings;

import cr.launcher.eb;

import java.lang.reflect.Field;

public class PlayerCapabilities{

    public static void SetisFlying(boolean value) {
        try {
            Class<?> thePlayerClass = com.craftrise.mg.class;
            Field sField = thePlayerClass.getDeclaredField("S");
            sField.setAccessible(true);
            Object sObject = sField.get(TheMinecraft.GetPlayer());
            Field hField = sObject.getClass().getDeclaredField("h");
            hField.setAccessible(true);
            hField.set(sObject, new eb(value, cr.launcher.main.a.m));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void SetAllowFlying(boolean value) {
        try {
            Class<?> thePlayerClass = com.craftrise.mg.class;
            Field sField = thePlayerClass.getDeclaredField("S");
            sField.setAccessible(true);
            Object sObject = sField.get(TheMinecraft.GetPlayer());
            Field hField = sObject.getClass().getDeclaredField("k");
            hField.setAccessible(true);
            hField.set(sObject, new eb(value, cr.launcher.main.a.m));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void DisableDamage(boolean value){
        try {
            Class<?> thePlayerClass = com.craftrise.mg.class;
            Field sField = thePlayerClass.getDeclaredField("S");
            sField.setAccessible(true);
            Object sObject = sField.get(TheMinecraft.GetPlayer());
            Field hField = sObject.getClass().getDeclaredField("b");
            hField.setAccessible(true);
            hField.set(sObject, new eb(value, cr.launcher.main.a.m));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void SetisCreativeMode(boolean value){
        try {
            Class<?> thePlayerClass = com.craftrise.mg.class;
            Field sField = thePlayerClass.getDeclaredField("S");
            sField.setAccessible(true);
            Object sObject = sField.get(TheMinecraft.GetPlayer());
            Field hField = sObject.getClass().getDeclaredField("e");
            hField.setAccessible(true);
            hField.set(sObject, new eb(value, cr.launcher.main.a.m));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void SetflySpeed(float value){
        try {
            Class<?> thePlayerClass = com.craftrise.mg.class;
            Field sField = thePlayerClass.getDeclaredField("S");
            sField.setAccessible(true);
            Object sObject = sField.get(TheMinecraft.GetPlayer());
            Field hField = sObject.getClass().getDeclaredField("c");
            hField.setAccessible(true);
            hField.set(sObject, new com.craftrise.de(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void SetwalkSpeed(float value){
        try {
            Class<?> thePlayerClass = com.craftrise.mg.class;
            Field sField = thePlayerClass.getDeclaredField("S");
            sField.setAccessible(true);
            Object sObject = sField.get(TheMinecraft.GetPlayer());
            Field hField = sObject.getClass().getDeclaredField("j");
            hField.setAccessible(true);
            hField.set(sObject, new com.craftrise.de(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
