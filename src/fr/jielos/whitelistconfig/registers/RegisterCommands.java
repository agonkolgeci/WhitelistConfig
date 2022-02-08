package fr.jielos.whitelistconfig.registers;

import fr.jielos.whitelistconfig.command.WlcCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class RegisterCommands {

    public static void register(JavaPlugin instance) {
        instance.getCommand("whitelistconfig").setExecutor(new WlcCommand());
    }

}
