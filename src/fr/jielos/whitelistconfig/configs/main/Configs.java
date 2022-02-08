package fr.jielos.whitelistconfig.configs.main;

import fr.jielos.whitelistconfig.Main;

import java.io.File;

public enum Configs {

    MAIN("config.yml"),
    MESSAGES("messages.yml");

    private final File file;
    Configs(String fileName) {
        this.file = new File(Main.getInstance().getDataFolder(), fileName);
    }

    public File getFile() {
        return this.file;
    }
}
