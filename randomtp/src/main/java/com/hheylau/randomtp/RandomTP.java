package com.hheylau.randomtp;

import com.hheylau.randomtp.rtp.Random1;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomTP extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Random1(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
