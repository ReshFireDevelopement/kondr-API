package ru.kondr.api;

import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.bukkit.plugin.java.*;

@Plugin(name = "kondr-API", version = "1.0.0", category = "")
@Author("kondr")
public class Main extends JavaPlugin
{
    private static Main instance;
    
    public void onEnable() {
        (Main.instance = this).load();
    }
    
    public void load() {
    }
    
    public static Main getInstance() {
        return Main.instance;
    }
}
