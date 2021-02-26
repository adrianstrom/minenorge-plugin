package me.thedudeadrian.minenorge.commands;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thedudeadrian.minenorge.Main;

public class SleepCommand extends Object implements CommandExecutor, Cloneable {
	private Main plugin;

	public SleepCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("sov").setExecutor(this);
	}

	public void SetTime(Player player, int noOfPlayersSleeping, int noOfPlayersOnline) {
		for (World world : Bukkit.getServer().getWorlds()) {
			world.setTime(0);
		}
		player.sendMessage(noOfPlayersSleeping + " ut av " + noOfPlayersOnline + " personer sov, som gjorde at tiden ble satt til dag!");
	}

	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {

		Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
		Player player = (Player) sender;

		if (player.isSleeping()) {
			int noOfPlayersOnline = 0;
			int noOfPlayersSleeping = 0;

			for (Player p : onlinePlayers) {
				noOfPlayersOnline++;
				if (p.isSleeping()) {
					noOfPlayersSleeping++;
				}
			}
			if (!player.hasPermission("sov.use")) {
				if (noOfPlayersSleeping == 1 || noOfPlayersOnline == 2 || noOfPlayersOnline == 3) {
					if (noOfPlayersSleeping == 1) {
						SetTime(player, noOfPlayersSleeping, noOfPlayersOnline);
					} else {
						player.sendMessage("Minst en person må sove!");
					}
				} else if (noOfPlayersOnline == 4 || noOfPlayersOnline == 5) {
					if (noOfPlayersSleeping == 2) {
						SetTime(player, noOfPlayersSleeping, noOfPlayersOnline);
					} else {
						player.sendMessage("Minst to personer må sove!");
					}
				} else if (noOfPlayersOnline > 5) {
					if (noOfPlayersSleeping == 3) {
						SetTime(player, noOfPlayersSleeping, noOfPlayersOnline);
					} else {
						player.sendMessage("Minst tre personer må sove!");
					}
				} else {
					if (noOfPlayersSleeping == 0) {

					}
				}
				return true;
			}
		} else {
			player.sendMessage("Du må sove for å bruke denne kommandoen!");
		}
		return false;
	}
}
