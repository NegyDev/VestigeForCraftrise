package vestige.module.impl.render;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import vestige.Vestige;
import vestige.event.Event;
import vestige.event.impl.EventRender;
import vestige.font.FontUtil;
import vestige.font.MinecraftFontRenderer;
import vestige.module.Category;
import vestige.module.Module;
import vestige.setting.impl.ModeSetting;
import vestige.util.misc.MathUtils;
import vestige.util.render.ColorUtil;
import vestige.util.render.DrawUtil;

public class HUD extends Module {
	
	public ModeSetting mode = new ModeSetting("Mode", "Vestige v1", "Vestige v1", "Vestige v2", "Astolfo");
	
	public HUD() {
		super("HUD", Category.RENDER);
		this.addSettings(mode);
		this.setEnabledSilently(true);
	}
	
	public void onEvent(Event event) {
		if(event instanceof EventRender) {
			switch(mode.getMode()) {
			case "Vestige v1":
				renderVestigeV1();
				break;
			case "Vestige v2":
				renderVestigeV2();
				break;
			case "Astolfo":
				renderAstolfo();
				break;
			}
		}
	}
	
	private void renderVestigeV1() {
		MinecraftFontRenderer fr = FontUtil.product_sans;
		ScaledResolution sr = new ScaledResolution(mc);
		
		drawVestigeV1WaterMark(fr);
		
		ArrayList<Module> moduleList = getEnabledModules();
		
		try {
			moduleList.sort((m1, m2) -> (int) (Math.round((fr.getStringWidth(m1.getDisplayName()) * 2) - Math.round(fr.getStringWidth(m2.getDisplayName()) * 2))));
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		Collections.reverse(moduleList);
		
		int offsetY = 6;
		
		for(Module m : moduleList) {
			String displayName = m.getDisplayName();
			double nameLength = fr.getStringWidth(displayName);
			
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.getDisplayName()) - 8, offsetY, sr.getScaledWidth() - 3, offsetY + 11, 0x70000000);
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.getDisplayName()) - 10, offsetY, sr.getScaledWidth() - fr.getStringWidth(m.getDisplayName()) - 8, offsetY + 11, ColorUtil.vestigeColors(1.5F, offsetY * -10));
			fr.drawStringWithShadow(m.getDisplayName(), sr.getScaledWidth() - fr.getStringWidth(m.getDisplayName()) - 6, offsetY + 1.5F, ColorUtil.vestigeColors(1.5F, offsetY * -10));
			
			offsetY += 11;
		}
	}
	
	private void drawVestigeV1WaterMark(MinecraftFontRenderer fr) {
		String s = Vestige.getFullFormattedName() + " | " + mc.getDebugFPS() + "FPS | " + Vestige.getUsername();
		for(int i = 0; i < 2; i++) {
			DrawUtil.drawRoundedRect(3, 2, fr.getStringWidth(s) + 10, 20, 4.5, 0x60000000);
		}
		int aaa = 0;
		for(int i = 6; i < fr.getStringWidth(s) + 6; i++) {
			if(i == 6) {
				Gui.drawRect(i - 0.5, 3, i + 1, 3.5, ColorUtil.vestigeColors(3F, 25 - (i * 10)));						
				Gui.drawRect(i - 1, 3.5, i + 1, 4, ColorUtil.vestigeColors(3F, 25 - (i * 10)));						
				Gui.drawRect(i - 1, 4, i + 1, 4.5, ColorUtil.vestigeColors(3F, 25 - (i * 10)));
				Gui.drawRect(i - 1, 4.5, i + 1, 5, ColorUtil.vestigeColors(3F, 25 - (i * 10)));					
				Gui.drawRect(i - 1, 5, i + 1, 5.5, ColorUtil.vestigeColors(3F, 25 - (i * 10)));
				Gui.drawRect(i - 0.5, 5.5, i + 1, 6, ColorUtil.vestigeColors(3F, 25 - (i * 10)));
			}
			Gui.drawRect(i, 3, i + 1, 6, ColorUtil.vestigeColors(3F, 25 - (i * 10)));
			aaa = i;
		}
		Gui.drawRect(aaa, 3, aaa + 2, 3.5, ColorUtil.vestigeColors(3F, 25 - (aaa * 10)));						
		Gui.drawRect(aaa, 3.5, aaa + 2.5, 4, ColorUtil.vestigeColors(3F, 25 - (aaa * 10)));						
		Gui.drawRect(aaa, 4, aaa + 2.5, 4.5, ColorUtil.vestigeColors(3F, 25 - (aaa * 10)));
		Gui.drawRect(aaa, 4.5, aaa + 2.5, 5, ColorUtil.vestigeColors(3F, 25 - (aaa * 10)));					
		Gui.drawRect(aaa, 5, aaa + 2.5, 5.5, ColorUtil.vestigeColors(3F, 25 - (aaa * 10)));
		Gui.drawRect(aaa, 5.5, aaa + 2, 6, ColorUtil.vestigeColors(3F, 25 - (aaa * 10)));
		
		DrawUtil.drawRoundedRect(6, 5, fr.getStringWidth(s) + 7, 7, 4, 0x300e5de6);
		fr.drawStringWithShadow(s, 6, 9, ColorUtil.vestigeColors(3F, -50));
	}

	private void renderVestigeV2() {
		final MinecraftFontRenderer fr = FontUtil.product_sans;
		final ScaledResolution sr = new ScaledResolution(mc);
		
		fr.drawStringWithShadow(Vestige.getFullFormattedName(), 4, 4, ColorUtil.vestigeColors(2.3F, 20));
		
		ArrayList<Module> moduleList = getEnabledModules();
		
		try {
			moduleList.sort((m1, m2) -> (int) (Math.round((fr.getStringWidth(m1.getDisplayName()) * 2) - Math.round(fr.getStringWidth(m2.getDisplayName()) * 2))));
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		Collections.reverse(moduleList);
		
		int offsetY = 6;
		
		for(Module m : moduleList) {
			String displayName = m.getDisplayName();
			double nameLength = fr.getStringWidth(displayName);
			
			for(int i = 0; i < 12; i++) {
				Gui.drawRect(sr.getScaledWidth() - 5, offsetY - 1 + i, sr.getScaledWidth() - 3, offsetY + i, ColorUtil.vestigeColors(2.3F, (offsetY + i - 1) * 25));
			}
			Gui.drawRect(sr.getScaledWidth() - nameLength - 11, offsetY - 1, sr.getScaledWidth() - 5, offsetY + 11, 0x80000000);
			fr.drawStringWithShadow(displayName, sr.getScaledWidth() - nameLength - 8, offsetY + 1, ColorUtil.vestigeColors(2.3F, offsetY * 25));
			offsetY += 12;
		}
	}
	
	private void renderAstolfo() {
		final MinecraftFontRenderer fr = FontUtil.product_sans;
		final ScaledResolution sr = new ScaledResolution(mc);
		
		fr.drawStringWithShadow(Vestige.getFullFormattedName(), 4, 4, ColorUtil.astolfoColors(2, 40));
		
		//float bpt = (float) (MathUtils.square(mc.thePlayer.posX - mc.thePlayer.lastTickPosX) + MathUtils.square(mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ));
		//float bps = (float) MathUtils.round((Math.sqrt(bpt) * 20) * mc.timer.timerSpeed, 0.01);
		
	//String bpsrender = "BPS : " + bps;

		//fr.drawStringWithShadow(bpsrender, 3, sr.getScaledHeight() - 12, -1);
		
		ArrayList<Module> moduleList = getEnabledModules();
		
		try {
			moduleList.sort((m1, m2) -> (int) (Math.round((fr.getStringWidth(m1.getDisplayName()) * 2) - Math.round(fr.getStringWidth(m2.getDisplayName()) * 2))));
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		Collections.reverse(moduleList);
		
		int offsetY = 6;
		
		for(Module m : moduleList) {
			String displayName = m.getDisplayName();
			double nameLength = fr.getStringWidth(displayName);
			
			for(int i = 0; i < 11; i++) {
				Gui.drawRect(sr.getScaledWidth() - 5, offsetY + i, sr.getScaledWidth() - 3, offsetY + i + 1, ColorUtil.astolfoColors(2, (int) ((offsetY + i - 1) * 1.3)));
			}
			Gui.drawRect(sr.getScaledWidth() - nameLength - 11, offsetY, sr.getScaledWidth() - 5, offsetY + 11, 0x80000000);
			fr.drawStringWithShadow(displayName, sr.getScaledWidth() - nameLength - 8, offsetY + 1.5F, ColorUtil.astolfoColors(2, (int) (offsetY * 1.3)));
			offsetY += 11;
		}
	}
	
	private ArrayList<Module> getEnabledModules() {
		ArrayList<Module> enabledModules = new ArrayList<>();
		for(Module m : Vestige.getModuleManager().getModules()) {
			if(m.isEnabled()) {
				enabledModules.add(m);
			}
		}
		return enabledModules;
	}
	
}