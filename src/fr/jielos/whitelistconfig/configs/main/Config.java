package fr.jielos.whitelistconfig.configs.main;

import fr.jielos.whitelistconfig.configs.ConfigsManager;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Config {

    private JavaPlugin instance;
    private final File file;
    private final FileConfiguration fileConfiguration;
    public Config(JavaPlugin instance, File file) {
        this.instance = instance;
        this.file = file;
        this.fileConfiguration = new YamlConfiguration();
        ConfigsManager.getConfigs().put(this.file, this);
    }

    public void load() {
        if(!this.file.exists()) {
            this.file.getParentFile().mkdirs();
            instance.saveResource(this.file.getName(), false);
        }

        try { this.fileConfiguration.load(this.file); }
        catch (IOException | InvalidConfigurationException e) { e.printStackTrace(); }

        ConfigsManager.getConfigs().put(this.file, this);
    }

    public void save() {
        try { this.fileConfiguration.save(this.file); }
        catch (IOException e) { e.printStackTrace(); }
    }
    public void reload() {
        try { this.fileConfiguration.load(this.file); }
        catch (IOException | InvalidConfigurationException e) { e.printStackTrace(); }
    }

    public File getFile() { return file; }
    public FileConfiguration getFileConfiguration() { return fileConfiguration; }
}
