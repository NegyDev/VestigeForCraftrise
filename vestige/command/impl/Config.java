package vestige.command.impl;

import vestige.Vestige;
import vestige.command.Command;
import vestige.config.SaveLoad;

import java.io.IOException;

public class Config extends Command {
    public Config() {
        super("Config", "config issue", ".config <args>", "cfg");
    }

    @Override
    public void onCommand(String[] args, String command) {
        if(args.length > 1) {
            String action = args[0];

            if(args[1] == null) return;

            if(action.equalsIgnoreCase("load")) {
                SaveLoad saveLoad1 = new SaveLoad(args[1], false);
                saveLoad1.load(false);
                Vestige.addChatMessage("Loaded config " + args[1]);
            }
            if(action.equalsIgnoreCase("save")) {
                SaveLoad saveLoad2 = new SaveLoad(args[1], false);
                saveLoad2.save();
                Vestige.addChatMessage("Saved config " + args[1]);
            }
            if(action.equalsIgnoreCase("")) {
                SaveLoad saveLoad2 = new SaveLoad("default", false);
                saveLoad2.save();
                Vestige.addChatMessage("Saved config default");
            }
        }
    }
}
