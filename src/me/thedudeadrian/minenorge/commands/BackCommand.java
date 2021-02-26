package me.thedudeadrian.minenorge.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thedudeadrian.minenorge.Main;

public class BackCommand extends Object implements CommandExecutor, Cloneable {

	private Main plugin;

	public BackCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("tilbake").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (!player.hasPermission("tilbake.use")) {
			if (PreviousPosition.Location != null) {
				player.teleport(PreviousPosition.Location);
			} else
			{
				player.sendMessage("Du har ingen posisjon å teleportere tilbake til!");
			}
			return true;
		}
		return false;
	}

}
