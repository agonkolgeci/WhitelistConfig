package fr.jielos.whitelistconfig.listeners;

import static fr.jielos.whitelistconfig.utils.Util.*;

import fr.jielos.whitelistconfig.configs.main.Configs;
import fr.jielos.whitelistconfig.permissions.PermissionsManager;
import fr.jielos.whitelistconfig.references.Permissions;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLogin implements Listener {
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e) {
		Player player = e.getPlayer();

		if(gcf(Configs.MAIN).getBoolean("whitelist.enabled")) {
			if(gcf(Configs.MAIN).getStringList("whitelist.players").contains(player.getName())) return;
			if(PermissionsManager.hasPermission(player, Permissions.BYPASS_WHITELIST)) return;
			e.disallow(PlayerLoginEvent.Result.KICK_OTHER, tm("whitelist.notWhitelisted"));
		}
	}
	
}
