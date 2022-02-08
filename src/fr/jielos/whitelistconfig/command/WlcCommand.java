package fr.jielos.whitelistconfig.command;

import static fr.jielos.whitelistconfig.utils.Util.*;

import java.util.List;

import fr.jielos.whitelistconfig.configs.main.Configs;
import fr.jielos.whitelistconfig.permissions.PermissionsManager;
import fr.jielos.whitelistconfig.references.Permissions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class WlcCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!PermissionsManager.hasPermission(sender, Permissions.COMMAND.getValue())) {
			sender.sendMessage(tm("insufficientPermission"));
			return false;
		}

		if(args.length >= 1) {
			if(PermissionsManager.hasPermission(sender, Permissions.COMMAND)) {
				SubCommands subCommand = SubCommands.getByName(args[0]);
				if(subCommand == null) {
					sender.sendMessage(tm("unknownCommand"));
					return false;
				}

				if(!PermissionsManager.hasPermission(sender, subCommand.getPermission())) {
					sender.sendMessage(tm("insufficientPermission"));
					return false;
				}

				switch(subCommand) {
					case WLC_HELP:
						sender.sendMessage("");
						sender.sendMessage("§f§l" + tm("commands-descriptions.title"));
						sender.sendMessage(" §6/§fwlc §e[help] §7: §f" + tm("commands-descriptions.help"));
						sender.sendMessage(" §6/§fwlc §e[enable/disable] §7: §f" + tm("commands-descriptions.enable-disable"));
						sender.sendMessage(" §6/§fwlc §e[add/remove] §b[playername] §7: §f" + tm("commands-descriptions.add-remove"));
						sender.sendMessage(" §6/§fwlc §e[list] §7: §f" + tm("commands-descriptions.list"));
						sender.sendMessage(" §6/§fwlc §e[reload] §7: §f" + tm("commands-descriptions.reload"));
						sender.sendMessage("");
						return true;

					case WLC_ENABLE:
						if(!gcf(Configs.MAIN).getBoolean("whitelist.enabled")) {
							gcf(Configs.MAIN).set("whitelist.enabled", true);
							gc(Configs.MAIN).save();
							sender.sendMessage(tm("command-actions.enable.enabledWhitelist"));
							return true;
						}

						sender.sendMessage(tm("command-actions.enable.alreadyEnable"));
						return true;

					case WLC_DISABLE:
						if(gcf(Configs.MAIN).getBoolean("whitelist.enabled")) {
							gcf(Configs.MAIN).set("whitelist.enabled", false);
							gc(Configs.MAIN).save();
							sender.sendMessage(tm("command-actions.disable.disabledWhitelist"));
							return true;
						}

						sender.sendMessage(tm("command-actions.disable.alreadyDisable"));
						return true;

					case WLC_ADD:
						if(args.length >= 2) {
							final String target = args[1];
							if(getPlayersList().contains(target)) {
								sender.sendMessage(tm("command-actions.add.alreadyAdded", target));
								return true;
							}

							List<String> playersList = getPlayersList(); playersList.add(target);
							gcf(Configs.MAIN).set("whitelist.players", playersList);
							gc(Configs.MAIN).save();
							sender.sendMessage(tm("command-actions.add.addedPlayer", target));
							return true;
						}

						sender.sendMessage(tm("syntaxError", "/whitelistconfig add [playername]"));
						return true;

					case WLC_REMOVE:
						if(args.length >= 2) {
							final String target = args[1];
							if(!getPlayersList().contains(target)) {
								sender.sendMessage(tm("command-actions.remove.playerNotFound", target));
								return true;
							}

							List<String> playersList = getPlayersList(); playersList.remove(target);
							gcf(Configs.MAIN).set("whitelist.players", playersList);
							gc(Configs.MAIN).save();
							sender.sendMessage(tm("command-actions.remove.removedPlayer", target));
							return true;
						}

						sender.sendMessage(tm("syntaxError", "/whitelistconfig remove [playername]"));
						return true;

					case WLC_LIST:
						if(getPlayersList().isEmpty()) {
							sender.sendMessage(tm("command-actions.list.nonePlayers"));
							return true;
						}

						String playersList = gcf(Configs.MAIN).getString("whitelist.players").replace("[", "").replace("]", "");
						sender.sendMessage(tm("command-actions.list.playersList"));
						sender.sendMessage(tm("command-actions.list.playersRegistered", playersList));
						return true;

					case WLC_RELOAD:
						gc(Configs.MAIN).reload();
						gc(Configs.MESSAGES).reload();
						sender.sendMessage(tm("command-actions.reload.reloadConfigs"));
						return true;

					default:
						sender.sendMessage(tm("unknownCommand"));
						return false;
				}
			}

			sender.sendMessage(tm("insufficientPermission"));
			return false;
		}

		sender.sendMessage(tm("unknownCommand"));
		return false;
	}

	public List<String> getPlayersList() {
		return gcf(Configs.MAIN).getStringList("whitelist.players");
	}

}
