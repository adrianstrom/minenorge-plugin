package me.thedudeadrian.minenorge.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.thedudeadrian.minenorge.Main;

public class GetSlurker extends Object implements CommandExecutor, Cloneable {

	private Main plugin;

	public GetSlurker(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("bet").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return false;
	}
}
