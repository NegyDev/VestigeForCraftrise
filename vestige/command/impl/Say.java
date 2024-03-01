package vestige.command.impl;

import net.minecraft.client.Minecraft;
import com.craftrise.d3;
import vestige.Vestige;
import vestige.command.Command;
import vestige.module.Module;

public class Say extends Command {
	
	public Say() {
		super("Say", "Says things in chat", "say", "s");
	}

	@Override
	public void onCommand(String[] args, String command) {
		Vestige.GetPlayer().z.a(new d3(String.join(" ", args)),5L);
	}

}
