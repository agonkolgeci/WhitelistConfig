package fr.jielos.whitelistconfig.configs;

import fr.jielos.whitelistconfig.configs.main.Config;
import fr.jielos.whitelistconfig.configs.main.Configs;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ConfigsManager {

    private static Map<File, Config> configs = new HashMap<>();
    public static Config getConfig(Configs config) { return configs.get(config.getFile()); }
    public static Map<File, Config> getConfigs() { return configs; }

}
