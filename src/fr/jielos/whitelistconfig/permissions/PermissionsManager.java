package fr.jielos.whitelistconfig.permissions;

import fr.jielos.whitelistconfig.references.Permissions;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PermissionsManager {

    public static boolean hasPermission(CommandSender commandSender, String permission) {
        if(commandSender.hasPermission(Permissions.ALL.getValue())) return true;
        return commandSender.hasPermission(permission);
    }

    public static boolean hasPermission(CommandSender commandSender, Permissions permission) {
        if(commandSender.hasPermission(Permissions.ALL.getValue())) return true;
        return commandSender.hasPermission(permission.getValue());
    }

    public static boolean hasPermission(Player player, String permission) {
        if(player.hasPermission(Permissions.ALL.getValue())) return true;
        return player.hasPermission(permission);
    }

    public static boolean hasPermission(Player player, Permissions permission) {
        if(player.hasPermission(Permissions.ALL.getValue())) return true;
        return player.hasPermission(permission.getValue());
    }

}
