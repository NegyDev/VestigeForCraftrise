package vestige;

import org.lwjgl.opengl.Display;

import com.mojang.realmsclient.gui.ChatFormatting;

import cr.launcher.ChatComponentText;
import cr.launcher.Config;
import net.minecraft.client.Minecraft;
import vestige.command.CommandManager;
import vestige.config.SaveLoad;
import vestige.font.FontUtil;
import vestige.module.ModuleManager;
import vestige.util.base.BaseUtil;
import com.craftrise.client.dt;
import cr.launcher.main.a;

public class Vestige implements BaseUtil {
	
	private static final Vestige instance = new Vestige();
	
	private static final String name = "Hotline";
	private static final String version = "beta 2.0";
	
	private static final String formattedName = "V" + ChatFormatting.WHITE + "estige";
	
	private static String username;
	
	private static ModuleManager moduleManager;
	private static CommandManager commandManager;
	
	private static SaveLoad config;
	public static int isStarted = 0;
	
	
	
	public static void setIngameGui(dt Gui) {
		Config.getMinecraft().K = Gui;
	}
	
	public static void start() {
		if(isStarted <=0) {
		Minecraft.init();
		System.out.println(getConsolePrefix() + "Loading Client");
		
		moduleManager = new ModuleManager();
		System.out.println(getConsolePrefix() + "Loaded Modules");
		
		config = new SaveLoad("default", true);
		config.load(true);
		System.out.println("Loaded Default Config");
		
		commandManager = new CommandManager();
		System.out.println(getConsolePrefix() + "Loaded Command Manager");
		
		System.out.println(getConsolePrefix() + "Loaded Processors");
		
		try {
			FontUtil.bootstrap();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Loaded Custom FontRenderer Util");
		
		//Display.setTitle(getFullName() + " | Minecraft 1.8.9");
		setIngameGui(new GuiIngameHook(Config.getMinecraft().K));
		isStarted++;
		}
	}
	
	public static void shutdown() {
		config.save();
	}
	
	public static Vestige getInstance() {
		return instance;
	}
	
	public static String getName() {
		return name;
	}
	
	public static String getVersion() {
		return version;
	}
	
	public static String getFormattedName() {
		return formattedName;
	}
	
	public static String getFullName() {
		return name + " " + version;
	}
	
	public static String getFullFormattedName() {
		return formattedName + " " + version;
	}
	
	public static ModuleManager getModuleManager() {
		return moduleManager;
	}
	
	public static CommandManager getCommandManager() {
		return commandManager;
	}
	public static com.craftrise.client.fa GetPlayer(){
        return a.q;
    }
	
	
	public static void addChatMessage(String message) {
		message = ChatFormatting.BLUE + "Vestige" + ChatFormatting.WHITE + " : " + message;
		
		GetPlayer().a(new ChatComponentText(message),5L);
	}
	
	public static String getConsolePrefix() {
		return "[" + getFullName() + "] : ";
	}
	
	public static String getUsername() {
		return "Hotlinexd";
	}
	
	public static void setUsername(String username) {
		Vestige.username = username;
	}
	
}