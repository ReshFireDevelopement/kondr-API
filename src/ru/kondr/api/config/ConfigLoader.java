package ru.kondr.api.config;

import org.bukkit.plugin.*;
import java.util.*;

public class ConfigLoader
{
    Map<String, Config> configs;
    public Plugin plugin;
    
    public void load(final String string) {
        this.configs.put(string, new Config(this.plugin, string));
    }
    
    public ConfigLoader(final Plugin plugin) {
        this.configs = new HashMap<String, Config>();
        this.plugin = plugin;
    }
    
    public void saveAll() {
        for (final Map.Entry<String, Config> entry : this.configs.entrySet()) {
            entry.getValue().save();
        }
    }
    
    public void save(final String name) {
        this.configs.get(name).save();
    }
    
    public void unload(final String name) {
        if (this.configs.containsKey(name)) {
            this.configs.remove(name);
        }
    }
    
    public void reloadAll() {
        for (final Map.Entry<String, Config> entry : this.configs.entrySet()) {
            entry.getValue().reload();
        }
    }
    
    public Config get(final String string) {
        if (!this.configs.containsKey(string)) {
            this.load(string);
        }
        return this.configs.get(string);
    }
}
