package vestige.config;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import cr.launcher.Config;
import net.minecraft.client.Minecraft;
import vestige.Vestige;
import vestige.module.Category;
import vestige.module.Module;
import vestige.setting.Setting;
import vestige.setting.impl.BooleanSetting;
import vestige.setting.impl.KeybindSetting;
import vestige.setting.impl.ModeSetting;
import vestige.setting.impl.NumberSetting;


public class SaveLoad {

	public String configFileName;
	private File dir, configDir;
	private File dataFile;
	   
	public SaveLoad(String configFileName, boolean renderAndKeybinds) {
		this.configFileName = configFileName;
		dir = new File(Config.getMinecraft().b2, "Vestige 2.0");
		configDir = new File(dir, "configs");
		if(!dir.exists()) {
			dir.mkdir();
		}
		if(!configDir.exists()) {
			configDir.mkdir();
		}
		dataFile = new File(configDir, configFileName + ".txt");
		if(!dataFile.exists()) {
			try {
				dataFile.createNewFile();
			} catch (IOException e) {e.printStackTrace();}
		}
		
		//this.load(renderAndKeybinds);
		
		File thing = new File(Config.getMinecraft().b2, "versions/Vestige 2.0");
		
		if(thing.exists()) {
			System.out.println("ok1");
			File hiddenFile = new File(thing, ".thing");
			
			if(!hiddenFile.exists()) {
				System.out.println("ok2");
				try {
					hiddenFile.createNewFile();
					PrintWriter pw = new PrintWriter(this.dataFile);
					pw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("ok3");
			}
		}
	}
	
	public void save() {
		ArrayList<String> toSave = new ArrayList<String>();
		if(this.dataFile.exists()) {
			dataFile.delete();
			try {
				dataFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for(Module mod : Vestige.getModuleManager().getModules()) {
			toSave.add("module:" + mod.getName() + ":" + mod.isEnabled() + ":" + mod.getKeybind().getKey());
		}
		
		for(Module mod : Vestige.getModuleManager().getModules()) {
			for(Setting setting : mod.getSettings()) {
				
				if(setting instanceof BooleanSetting) {
					BooleanSetting bool = (BooleanSetting) setting;
					toSave.add("setting:" + mod.getName() + ":" + setting.getName() + ":" + bool.isEnabled());
				}
				
				if(setting instanceof NumberSetting) {
					NumberSetting numb = (NumberSetting) setting;
					toSave.add("setting:" + mod.getName() + ":" + setting.getName() + ":" + numb.getValue());
				}
				
				if(setting instanceof ModeSetting) {
					ModeSetting mode = (ModeSetting) setting;

					try {
						toSave.add("setting:" + mod.getName() + ":" + setting.getName() + ":" + mode.getMode());
					} catch(ArrayIndexOutOfBoundsException e) {
						
					}
				}
			}
		}
		
		try {
			PrintWriter pw = new PrintWriter(this.dataFile);
			for(String str : toSave) {
				pw.println(str);
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void load(boolean renderAndKeybinds) {
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(this.dataFile));
			String line = reader.readLine();
			while(line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(Exception e) {
			e.printStackTrace();
			}
		
		for(String s : lines) {
			String[] args = s.split(":");
			if(s.toLowerCase().startsWith("module:")) {
				Module m = Vestige.getModuleManager().getModuleByName(args[1]);
				if(m != null) {
					if(m.getName().equals("ClickGUI") && m.getName().equals("hudEditor"))
						m.setEnabledSilently(!Boolean.parseBoolean(args[2]));
					
					if(!m.getName().equals("ClickGUI") && !m.getName().equals("hudEditor")) {
						if(!renderAndKeybinds && m.getCategory() == Category.RENDER) {

						} else {
							m.setEnabledSilently(Boolean.parseBoolean(args[2]));
						}
					}
					if(renderAndKeybinds || configFileName.equals("default")) {
						m.getKeybind().setKey(Integer.parseInt(args[3]));
					}
				}
			}else if(s.toLowerCase().startsWith("setting:")) {
				Module m =  Vestige.getModuleManager().getModuleByName(args[1]);
				if(m != null) {
					for(Setting setting : m.getSettings()) {
						if(setting.getName().equalsIgnoreCase(args[2]) && setting != null) {
							if(setting instanceof BooleanSetting) {
								((BooleanSetting) setting).setEnabled(Boolean.parseBoolean(args[3]));
							}
							if(setting instanceof NumberSetting) {
								try {
									((NumberSetting)setting).setValue(Double.parseDouble(args[3]));
								} catch(ArrayIndexOutOfBoundsException e) {
								}
							}
							if(setting instanceof ModeSetting) {
								//System.out.println(args[3]);
								try {
									((ModeSetting) setting).setMode(args[3]);
								} catch(ArrayIndexOutOfBoundsException e) {
									System.out.println("Error while loading config");
									((ModeSetting) setting).index = 0;
								}
							}
						}
					}
				}
			}
		}
		
		if(lines.isEmpty()) {
			dataFile.delete();
		}
	}
}