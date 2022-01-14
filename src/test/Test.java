package test;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Test extends JavaPlugin
{

    @Override
    public void onLoad()
    {
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "[Test] Plugin is loading...");
    }

    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new TestListener(), this);

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Test] Plugin has been enabled!");
    }

    @Override
    public void onDisable()
    {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Test] Plugin has been disabled!");
    }
}
