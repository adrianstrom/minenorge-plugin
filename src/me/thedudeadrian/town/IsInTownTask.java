package me.thedudeadrian.town;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.thedudeadrian.minenorge.Main;

public class IsInTownTask extends BukkitRunnable {
	
	Main plugin;
	
	public IsInTownTask(Main plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public void run() {
		Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
		
		List<Integer> playerLocationX = new ArrayList<Integer>(); 
		List<Integer> playerLocationZ = new ArrayList<Integer>(); 
		List<Player> players = new ArrayList<Player>();
		
		for (Player p : onlinePlayers) {
			players.add(p);
		    playerLocationX.add(p.getLocation().getBlockX());
		    playerLocationZ.add(p.getLocation().getBlockZ());
		}
		
		Town town = new Town(plugin);
		Town[] towns = town.GetTowns();
		
		for (Town t : towns) 
		{
			for(Player p : onlinePlayers)
			{
				int distance = (int)Math.sqrt(Math.pow((p.getLocation().getBlockX()-t.LocationX), 2) + Math.pow((p.getLocation().getBlockZ()-t.LocationZ), 2));
				if(distance <= t.TownRadius)
				{
					p.sendMessage("Du er i " + t.TownName);
				}
			}

		}
	}
}
