package me.thedudeadrian.minenorge;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import me.thedudeadrian.minenorge.commands.BackCommand;
import me.thedudeadrian.minenorge.commands.Command;
import me.thedudeadrian.minenorge.commands.SleepCommand;
import me.thedudeadrian.minenorge.commands.betSlurker;
import me.thedudeadrian.minenorge.events.onChestOpened;
import me.thedudeadrian.minenorge.events.playerMovementEvent;
import me.thedudeadrian.town.CreateNewTownCommand;
import me.thedudeadrian.town.IsInTownTask;

public class Main extends JavaPlugin 
{	
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(new playerMovementEvent(this), this);
		getServer().getPluginManager().registerEvents(new onChestOpened(this), this);
		new CreateXmlFile(this);
		new Command(this);
		new BackCommand(this);
		new SleepCommand(this);
		new betSlurker(this);
		BukkitTask task =  new IsInTownTask(this).runTaskTimer(this, 0, 100);
		DataManager data = new DataManager(this);
		new CreateNewTownCommand(this);
		
	}
}
