package me.thedudeadrian.minenorge.commands;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thedudeadrian.minenorge.Main;

public class Command extends Object implements CommandExecutor, Cloneable {
	private Main plugin;

	public Command(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("godnatt").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
		{

			Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
			Player player = (Player)sender;
			Location bedLocation = player.getBedSpawnLocation();
			Location bed = new Location(player.getWorld(), bedLocation.getBlockX() + 1, bedLocation.getBlockY() + 1.5, bedLocation.getBlockZ());

			if (args.length == 0) {
				player.sendMessage("BedLocation");
				player.sendMessage(bedLocation.toString());
				player.sendMessage("Bed");
				player.sendMessage(bed.toString());
				if (!player.hasPermission("godnatt.use")) {
					for (Player p : onlinePlayers) {
						p.sleep(bed, true);
						return true;
					}
				}
			}

			if (args.length == 1) {
				player.sendMessage("Du har glemt å skrive inn y og z koordinater");
				return true;
			}

			if (args.length == 2) {
				player.sendMessage("Du har glemt å skrive inn z koordinaten");
				return true;
			}

			if (args.length == 3) {
				PreviousPosition.Location = player.getLocation();

				if (!player.hasPermission("godnatt.use")) {
					Location customLocation = new Location(player.getWorld(), Double.parseDouble(args[0]),
							Double.parseDouble(args[1]), Double.parseDouble(args[2]));

					for (Player p : onlinePlayers) {
						p.sleep(customLocation, true);
					}
				}
				
			    player.sendMessage("Skriv /tilbake for å bli teleportert tilbake der du var!");
				return true;
			}
		}
		return false;
	}
}
