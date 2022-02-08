package fr.jielos.whitelistconfig.registers;

import fr.jielos.whitelistconfig.configs.ConfigsManager;
import fr.jielos.whitelistconfig.configs.main.Config;
import fr.jielos.whitelistconfig.configs.main.Configs;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class RegisterConfigs {

    public static void register(JavaPlugin instance) {
        ArrayList<Config> configs = new ArrayList<>();
        for(Configs config : Configs.values()) {
            configs.add(new Config(instance, config.getFile()));
            ConfigsManager.getConfigs().get(config.getFile()).load();
        }
    }

}
