package org.oldfag.christmas;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.SimpleDateFormat;

/**
 * This plugin is designed for oldfag.org and will be used on Christmas 2020.
 * <p>
 * Everytime the player loads a chunk there will be a 0.01% chance that a custom mob will spawn.
 * This mob will be a husk with a lot of health and will drop a uniquely named book
 *
 * TODO: make world always snowing
 * @author John200410
 */
public final class Christmas2020 extends JavaPlugin {
	
	/**
	 * time formatting for books
	 */
	public final static SimpleDateFormat FORMAT = new SimpleDateFormat("hh:mm:ss a");
	
	@Override
	public void onEnable() {
		//register listener class
		Bukkit.getServer().getPluginManager().registerEvents(new Listeners(), this);
	}
	
	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
