package test;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

import java.util.ArrayList;

public class TestListener implements Listener
{

    public ArrayList<String> wooshing = new ArrayList<String>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {

        Player player = event.getPlayer();
        player.setAllowFlight(true);
        player.setFlying(false);
        event.setJoinMessage(ChatColor.GREEN + player.getName() + ChatColor.GRAY + " has connected!");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        event.setQuitMessage(ChatColor.RED + player.getName() + ChatColor.GRAY + " has connected.");
    }

    @EventHandler
    public void onPlayerToggleFlightEvent(PlayerToggleFlightEvent event)
    {
        Player player = event.getPlayer();

        if(player instanceof Player)
        {
            event.setCancelled(true);

            player.setAllowFlight(true);
            player.setFlying(false);

            String name = player.getName();

            player.setVelocity(player.getEyeLocation().getDirection().multiply(3));
            player.sendTitle(ChatColor.LIGHT_PURPLE + "Woosh", "", 1, 20, 1);
            wooshing.add(name);

        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event)
    {
        Entity entity = event.getEntity();

        if(entity instanceof Player)
        {
            if(event instanceof EntityDamageByEntityEvent)
            {
                return;
            }

            String name = entity.getName();

            if(wooshing.contains(name))
            {
                event.setCancelled(true);
                wooshing.remove(name);
            }
        }
    }

}
