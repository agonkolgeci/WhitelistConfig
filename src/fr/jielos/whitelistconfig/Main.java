package fr.jielos.whitelistconfig;

import fr.jielos.whitelistconfig.registers.RegisterCommands;
import fr.jielos.whitelistconfig.registers.RegisterConfigs;
import fr.jielos.whitelistconfig.registers.RegisterListeners;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	private static Main instance;

	@Override
	public void onEnable() {
		instance = this;

		RegisterCommands.register(this);
		RegisterListeners.register(this);
		RegisterConfigs.register(this);
	}
	
	public static Main getInstance() {
		return instance;
	}
}
