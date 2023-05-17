package com.hheylau.randomtp.rtp;

import org.bukkit.Location;
import org.bukkit.block.data.type.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class Random1 implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){} else if (sender instanceof ConsoleCommandSender) {

        } else if (sender instanceof CommandBlock) {
            System.out.println("");
        }

        return true;
    }
    public Location randomloca() {
        Random rand = new Random();
        Location loc;
        float x = rand.nextFloat();
        float y = rand.nextFloat();
        return  loc;
    }
}
