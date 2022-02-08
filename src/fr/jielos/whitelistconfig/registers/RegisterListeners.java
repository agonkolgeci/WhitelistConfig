package fr.jielos.whitelistconfig.registers;

import fr.jielos.whitelistconfig.listeners.PlayerLogin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RegisterListeners {

    public static void register(JavaPlugin instance) {
        PluginManager pluginManager = instance.getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerLogin(), instance);
    }

}
