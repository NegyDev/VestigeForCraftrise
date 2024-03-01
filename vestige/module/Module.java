package vestige.module;

import java.util.ArrayList;
import java.util.Arrays;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import vestige.event.Event;
import vestige.setting.Setting;
import vestige.setting.impl.KeybindSetting;
import vestige.util.base.ModuleBaseUtil;

public class Module implements ModuleBaseUtil {
	private static boolean keyPressed = false;
	
	private String name;
	private String displayName;
	private Category category;
	private KeybindSetting keybind = new KeybindSetting(0, this);
	
	private ArrayList<Setting> settings = new ArrayList<>();
	
	private boolean settingsShowed;
	
	private boolean enabled;
	private ListeningType listeningType = ListeningType.ENABLED;
	
	public Module(String name, Category category, ListeningType listeningType, int key) {
		this.name = name;
		this.displayName = name;
		this.category = category;
		this.listeningType = listeningType;
		this.keybind.setKey(key);
		this.addSettings(keybind);
	}
	
	public Module(String name, Category category, ListeningType listeningType) {
		this.name = name;
		this.displayName = name;
		this.category = category;
		this.listeningType = listeningType;
		this.addSettings(keybind);
	}
	
	public Module(String name, Category category, int key) {
		this.name = name;
		this.displayName = name;
		this.category = category;
		this.keybind.setKey(key);
		this.addSettings(keybind);
	}
	
	public Module(String name, Category category) {
		this.name = name;
		this.displayName = name;
		this.category = category;
		this.addSettings(keybind);
	}
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	public void onEvent(Event e) {
		
	}
	public static void KeyPress(int key) {
		for (Module m : ModuleManager.modules) {
			if (m.getKeybind().code != key) continue;
			m.toggle();
		}
	}
    public void onUpdate() {
		
	}
	public static void OnUpdateEvent() {
		for(Module m : vestige.Vestige.getModuleManager().getModules()){
			if(!m.enabled)continue;
			m.onUpdate();
		}
	}
	
	public static void KeyCheckEvent() {
		if (Keyboard.getEventKeyState()) {
			int k = Keyboard.getEventKey();
			if (!keyPressed) {
				KeyPress(k);
				keyPressed = true;
			}
		} else {
			keyPressed = false;
		}


	}
	
	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}
	
	public void setDisplayName(String newName) {
		this.displayName = newName;
	}

	public Category getCategory() {
		return category;
	}

	public KeybindSetting getKeybind() {
		return keybind;
	}
	
	public ListeningType getListeningType() {
		return listeningType;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		
		if(enabled) {
			onEnable();
		} else {
			onDisable();
		}
	}
	
	public void setEnabledSilently(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void toggle() {
		this.enabled = !this.enabled;
		
		if(this.enabled) {
			onEnable();
		} else {
			onDisable();
		}
	}
	
	public void toggleSilently() {
		this.enabled = !this.enabled;
	}
	
	public void addSettings(Setting... settings) {
		this.settings.addAll(Arrays.asList(settings));
	}
	
	public ArrayList<Setting> getSettings() {
		return settings;
	}
	
	public boolean isSettingsShowed() {
		return settingsShowed;
	}
	
	public void setSettingsShowed(boolean showed) {
		this.settingsShowed = showed;
	}
	
	public Setting getSettingByName(String name) {
		for(Setting s : settings) {
			if(s.getName().equals(name)) {
				return s;
			}
		}
		
		return null;
	}
	
}