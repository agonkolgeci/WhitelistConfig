package fr.jielos.whitelistconfig.utils;

import fr.jielos.whitelistconfig.configs.ConfigsManager;
import fr.jielos.whitelistconfig.configs.main.Config;
import fr.jielos.whitelistconfig.configs.main.Configs;
import org.bukkit.configuration.file.FileConfiguration;

public class Util {

	private static FileConfiguration messagesConfig = gcf(Configs.MESSAGES);

	public static String tm(String path) {
		return messagesConfig.getString(path)
				.replace("&", "§")
				.replace("{NEXT_LINE}", "\n");
	}
	public static String tm(String path, String arguments) {
		return messagesConfig.getString(path)
				.replace("&", "§")
				.replace("{0}", arguments)
				.replace("{NEXT_LINE}", "\n");
	}

	public static Config gc(Configs config) { return ConfigsManager.getConfig(config); }
	public static FileConfiguration gcf(Configs config) { return ConfigsManager.getConfig(config).getFileConfiguration(); }
	
}
