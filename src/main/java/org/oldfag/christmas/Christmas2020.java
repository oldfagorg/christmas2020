package org.oldfag.christmas;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.oldfag.christmas.packet.WrapperPlayServerMapChunk;

import java.text.SimpleDateFormat;

/**
 * This plugin is designed for oldfag.org and will be used on Christmas 2020.
 * <p>
 * Everytime the player loads a chunk there will be a 0.01% chance that a custom mob will spawn.
 * This mob will be a husk with a lot of health and will drop a uniquely named book
 *
 * @author John200410
 * @author charlie353535 23/12/2020
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
		
		//send ice plains biome with every chunk
		ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(this, ListenerPriority.HIGH, PacketType.Play.Server.MAP_CHUNK, PacketType.Play.Server.MAP_CHUNK_BULK) {
			@Override
			public void onPacketSending(PacketEvent event) {
				final WrapperPlayServerMapChunk wrapper = new WrapperPlayServerMapChunk(event.getPacket());

				final int lengthBegin = wrapper.getData().length - 256;
				for (int i = 0; i < 256; i++) {
					wrapper.getData()[lengthBegin+i] = 12; //12 = ice plains (https://minecraft.gamepedia.com/Biome/IDs_before_1.13)
				}
			}
		});

		//set weather to rain in every overworld world, and set duration to (basically) infinity.
		for (World w : getServer().getWorlds()) {
			if (w.getEnvironment().equals(World.Environment.NORMAL)) {
				w.setStorm(true);
				w.setWeatherDuration(Integer.MAX_VALUE); //2147483647 ticks = 3.4 years so we are probably OK
			}
		}
	}
}
