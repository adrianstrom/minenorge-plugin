package me.thedudeadrian.minenorge.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitTask;

import me.thedudeadrian.minenorge.Main;
import me.thedudeadrian.town.IsInTownTask;
import me.thedudeadrian.town.Town;

public class playerMovementEvent implements Listener {
	private Main plugin;
	public Town town;

	public playerMovementEvent(Main plugin) {
		this.plugin = plugin;
		//town = new Town();
	}
	
	@EventHandler
	public void onPlayerMovement(PlayerMoveEvent event)
	{
		if(event == null) return;
		/*	
	    double playerLocationX = event.getPlayer().getLocation().getBlockX();
		double playerLocationZ = event.getPlayer().getLocation().getBlockZ();
		
		Town town = new Town();
		Town[] towns = town.GetTowns();
		
		for (Town t : towns) 
		{
			int distance = (int)Math.sqrt(Math.pow((playerLocationX-t.LocationX), 2) + Math.pow((playerLocationZ-t.LocationZ), 2));
			if(distance <= t.TownRadius)
			{
				event.getPlayer().sendMessage("Du er i " + t.TownName);
			}
		}
		*/
		
	}

}