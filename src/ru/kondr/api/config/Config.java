package ru.kondr.api.config;

import org.bukkit.plugin.*;
import org.bukkit.*;
import java.io.*;
import org.bukkit.configuration.file.*;
import java.util.*;

public class Config
{
    public FileConfiguration fc;
    public Plugin plugin;
    public String name;
    public File file;
    public File dir;
    
    public Config(final Plugin plugin, final String name) {
        this.name = name;
        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), name + ".yml");
        this.dir = new File(this.file.getParent().toString());
        this.load();
    }
    
    public void save() {
        try {
            this.fc.save(this.file);
            this.plugin.getLogger().info("\u0421\u043e\u0445\u0440\u0430\u043d\u044f\u0435\u043c \u043a\u043e\u043d\u0444\u0438\u0433 " + ChatColor.GOLD + this.file.getAbsolutePath());
        }
        catch (IOException e) {
            e.printStackTrace();
            this.plugin.getLogger().warning("\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0441\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c \u043a\u043e\u043d\u0444\u0438\u0433 " + ChatColor.GOLD + this.file.getAbsolutePath());
        }
    }
    
    public void reload() {
        this.load();
    }
    
    private void load() {
        this.plugin.getLogger().info("\u0417\u0430\u0433\u0440\u0443\u0436\u0430\u0435\u043c " + ChatColor.GOLD + this.file.getAbsolutePath());
        try {
            if (!this.dir.exists()) {
                this.dir.mkdirs();
            }
            if (!this.file.exists()) {
                this.file.createNewFile();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            this.plugin.getLogger().warning("\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0437\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c " + ChatColor.GOLD + this.file.getAbsolutePath());
        }
        this.fc = (FileConfiguration)YamlConfiguration.loadConfiguration(this.file);
    }
    
    public Object get(final String path) {
        return this.fc.get(path);
    }
    
    public List<String> getStringList(final String path) {
        return (List<String>)this.fc.getStringList(path);
    }
    
    public String getString(final String path) {
        String s = (String)this.fc.get(path);
        if (s == null) {
            s = "\u043e\u0442\u0440\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u0443\u0439\u0442\u0435 \u043a\u043e\u043d\u0444\u0438\u0433 " + this.file.getAbsolutePath() + " &7(" + path + ")";
            this.set(path, s);
            this.save();
        }
        return s.replaceAll("&", "§");
    }
    
    public void set(final String path, final Object value) {
        this.fc.set(path, value);
    }
    
    public Set<String> getKeys(final boolean f) {
        return (Set<String>)this.fc.getKeys(f);
    }
}
