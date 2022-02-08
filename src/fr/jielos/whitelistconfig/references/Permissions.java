package fr.jielos.whitelistconfig.references;

public enum Permissions {

    ALL("whitelistconfig.*"),

    COMMAND("whitelistconfig.command"),
    COMMAND_ALL("whitelistconfig.command.*"),
    COMMAND_HELP("whitelistconfig.command.help"),
    COMMAND_MANAGE("whitelistconfig.command.manage"),
    COMMAND_LIST("whitelistconfig.command.list"),
    COMMAND_RELOAD("whitelistconfig.command.reload"),
    BYPASS_WHITELIST("whitelistconfig.bypass-whitelist");

    private String permission;
    Permissions(String permission) {
        this.permission = permission;
    }

    public String getValue() {
        return permission;
    }
}
