package fr.jielos.whitelistconfig.command;

import fr.jielos.whitelistconfig.references.Permissions;

public enum SubCommands {

    WLC_HELP("help", Permissions.COMMAND_HELP),
    WLC_ENABLE("enable", Permissions.COMMAND_MANAGE, "on"),
    WLC_DISABLE("disable", Permissions.COMMAND_MANAGE, "off"),
    WLC_ADD("add", Permissions.COMMAND_MANAGE),
    WLC_REMOVE("remove", Permissions.COMMAND_MANAGE),
    WLC_LIST("list", Permissions.COMMAND_LIST),
    WLC_RELOAD("reload", Permissions.COMMAND_LIST);

    private final String subCommandName;
    private final Permissions subCommandPermission;
    private String[] aliases;
    SubCommands(String subCommandName, Permissions subCommandPermission) {
        this.subCommandName = subCommandName;
        this.subCommandPermission = subCommandPermission;
    }

    SubCommands(String subCommandName, Permissions subCommandPermission, String... aliases) {
        this.subCommandName = subCommandName;
        this.subCommandPermission = subCommandPermission;
        this.aliases = aliases;
    }

    public String getName() {
        return subCommandName;
    }
    public Permissions getPermission() {
        return subCommandPermission;
    }
    public String[] getAliases() {
        return aliases;
    }

    public static SubCommands getByName(String name) {
        for(SubCommands command : SubCommands.values()) {
            if(command.getName().equalsIgnoreCase(name)) {
                return command;
            }

            if(command.getAliases() != null) {
                for(String alias : command.getAliases()) {
                    if(alias.equalsIgnoreCase(name)) {
                        return command;
                    }
                }
            }
        }
        return null;
    }
}
