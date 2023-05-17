package com.hheylau.randtp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class RandTP extends JavaPlugin implements Listener, CommandExecutor {

    @Override
    public void onEnable() {
        // Plugin startup logic
        //project done        System.out.println(getConfig().getInt("Distance"));
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this,this);
        getCommand("rtp").setExecutor(this::onCommand);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player pl = (Player)sender ;
            World world = pl.getWorld();
            randomtp(world, pl);
        } else if (sender instanceof ConsoleCommandSender) {
            if(args.length == 0){
                System.out.println("please specify player");
            }else {
                String attempt = args[0];
                Player pl = Bukkit.getServer().getPlayerExact(attempt);
                if(pl ==null){
                    System.out.println("Player not found");
                }else{
                    World world = pl.getWorld();
                    randomtp(world,pl);
                }
            }
        }
        return true;
    }

    private boolean checksafetp(String block1){
        switch (block1){
            case "WATER":
            case "LAVA":
                return true;
            default:
                return false;
        }
    }
    private void randomtp(World worldname,Player target) {
        Integer size = getConfig().getInt("Distance");
        Boolean repeat = false;
        Location loc;
        do {
            loc = new Location(worldname, randnum(size), 257 , randnum(size));
            Block block = loc.getBlock();
            while (block.getBlockData().getMaterial().toString() == "AIR") {
                loc.setY(loc.getY() - 1);
                block = loc.getBlock();
            }
            Location check = new Location(worldname,loc.getX(),loc.getY(),loc.getZ());
            check.setY(check.getY() - 1);
            Block block1 = check.getBlock();
            repeat = checksafetp(block1.getBlockData().getMaterial().toString());
        } while (repeat);
        loc.setY(loc.getY()+1);
        loc.setX(loc.getX() + 0.5);
        loc.setZ(loc.getZ()+0.5);
        loc.setYaw(randnum(180));
        target.teleport(loc);

    }
    private float randnum(Integer number){
        Random rand = new Random();
        Boolean positive = rand.nextBoolean();
        Float value = (float)rand.nextInt(number);
        if(positive) {
            value = value * -1;
        }
        return value;
    }
}
