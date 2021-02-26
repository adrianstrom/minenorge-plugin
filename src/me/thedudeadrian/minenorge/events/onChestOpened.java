package me.thedudeadrian.minenorge.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import me.thedudeadrian.minenorge.Main;

public class onChestOpened implements Listener {
	private Main plugin;

	public onChestOpened(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onChestOpenedEvent(PlayerInteractEvent event)
	{
		try
		{
		if(event == null)
		{
			return;
		}
		
		if (event.getClickedBlock().getType() == Material.CHEST || event.getClickedBlock().getType() == Material.BARREL) {
			plugin.getLogger().info(event.getPlayer().getDisplayName() + " opened chest at location " 
					+ "X: " + event.getClickedBlock().getLocation().getBlockX() + " Y: " + event.getClickedBlock().getLocation().getBlockY() + " Z: " + event.getClickedBlock().getLocation().getBlockZ() );
		}
		} catch (NullPointerException e)
		{
			
		}
	}
}
