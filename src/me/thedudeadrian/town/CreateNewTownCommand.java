package me.thedudeadrian.town;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.thedudeadrian.minenorge.DataManager;
import me.thedudeadrian.minenorge.Main;
import me.thedudeadrian.minenorge.commands.Utils;

public class CreateNewTownCommand extends Object implements CommandExecutor, Cloneable {
	private Main plugin;

	public CreateNewTownCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("by").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (args.length == 0) {
			player.sendMessage("Du bruker kommandoen på denne måten:");
			player.sendMessage("'/by lag <bynavn> <x koordinat> <z koordinat> <radius>");
			return true;
		}

		if (args.length == 1) {
			player.sendMessage("Du glemte å skrive bynavn, x koordinat, z koordinat og radius!");
			player.sendMessage("Du bruker kommandoen på denne måten:");
			player.sendMessage("'/by lag <bynavn> <x koordinat> <z koordinat> <radius>");
			return true;
		}

		if (args.length == 2) {
			player.sendMessage("Du glemte å skrive x koordinat, z koordinat og radius!");
			player.sendMessage("Du bruker kommandoen på denne måten:");
			player.sendMessage("'/by lag <bynavn> <x koordinat> <z koordinat> <radius>");
			return true;
		}
		
		if (args.length == 3) {
			player.sendMessage("Du glemte å skrive z koordinat og radius!");
			player.sendMessage("Du bruker kommandoen på denne måten:");
			player.sendMessage("'/by lag <bynavn> <x koordinat> <z koordinat> <radius>");
			return true;
		}
		
		if (args.length == 4) {
			player.sendMessage("Du glemte å skrive radius!");
			player.sendMessage("Du bruker kommandoen på denne måten:");
			player.sendMessage("'/by lag <bynavn> <x koordinat> <z koordinat> <radius>");
			return true;
		}
		
		if (args.length == 5) {
			String townName = args[1];
			int locationX = Integer.parseInt(args[2]);
			int locationZ = Integer.parseInt(args[3]);
			int radius = Integer.parseInt(args[4]);
			DataManager data = new DataManager(plugin);
			data.getConfig().set("towns." + townName + ".TownName", townName);
			data.getConfig().set("towns." + townName + ".LocationX", locationX);
			data.getConfig().set("towns." + townName + ".LocationZ", locationZ);
			data.getConfig().set("towns." + townName + ".Radius", radius);
			data.saveConfig();
			player.sendMessage(Utils.chat("&aByen " + townName + " ble opprettet!"));
			Town town = new Town(plugin);
			String townNames = String.join(", ", town.GetTownNames());
			player.sendMessage(Utils.chat("&eEksisterende byer: " + townNames));
			
			return true;
		}
		
		
		return false;
	}

}
