package me.thedudeadrian.minenorge.commands;



import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thedudeadrian.minenorge.Main;

public class betSlurker extends Object implements CommandExecutor, Cloneable {

	private Main plugin;

	public betSlurker(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("bet").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (!player.hasPermission("bet.use")) {
			
			if (args.length == 0) {
				player.sendMessage("Du bruker kommandoen på denne måten:");
				player.sendMessage("'/bet <spiller> <slurker>");
				return true;
			}

			if (args.length == 1) {
				player.sendMessage("Du glemte å skrive hvor mange slurker du better!");
				player.sendMessage("Du bruker kommandoen på denne måten:");
				player.sendMessage("'/bet <spiller> <slurker>");
				return true;
			}

			if (args.length == 2) {
				Bukkit.broadcastMessage(Utils.chat("&6[Sander PvP Arena]&7 " + player.getName() + " bettet " + args[1].toString() + " slurker på " + args[0].toString()));
				
				return true;
			}
		}
		return false;
	}

}
