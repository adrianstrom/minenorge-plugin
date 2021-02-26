package me.thedudeadrian.town;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import me.thedudeadrian.minenorge.DataManager;
import me.thedudeadrian.minenorge.Main;

public class Town
{
	public Main plugin;
	
	public String TownName;
	public String[] Citizens;
	public String Mayor;
	public int LocationX;
	public int LocationZ;
	public int TownRadius;
	public TownBank TownBank;
	
	public Town(String townName, int locationX, int locationZ, int radius, Main plugin)
	{
		this.plugin = plugin;
	}
	
	public static List<String> GetTownNames()
	{
		List<String> towns = new ArrayList<String>();
		DataManager data = new DataManager(plugin);
		for (String town : Objects.requireNonNull(data.getConfig().getConfigurationSection("towns")).getKeys(false))
		{
			towns.add(town);
		}
		return towns;
	}
	
	public static void AddTowns()
	{
		DataManager data = new DataManager(plugin);
		List<Town> towns = new ArrayList<Town>();
		for (String town : Objects.requireNonNull(data.getConfig().getConfigurationSection("towns")).getKeys(false))
		{
			String townName = data.getConfig().getString(town + ".TownName");
			int locationX = Integer.parseInt(data.getConfig().getString(town + ".LocationX"));
			int locationZ = Integer.parseInt(data.getConfig().getString(town + ".LocationZ"));
			int radius = Integer.parseInt(data.getConfig().getString(town + ".Radius"));
			towns.add(new Town(townName, locationX, locationZ, radius, plugin));		
		}
	}
}