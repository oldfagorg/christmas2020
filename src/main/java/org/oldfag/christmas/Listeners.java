package org.oldfag.christmas;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @author John200410 12/18/2020 for christmas
 */
public class Listeners implements Listener {
	
	@EventHandler
	private void onChunkLoad(ChunkLoadEvent event) {
		//random object
		final Random rand = new Random();
		
		//one in ten thousand chance (0.01%) that this will happen
		final boolean spawn = rand.nextInt(10000) == 69; //we use 69 here because it is funny number
		
		if(spawn && event.getWorld().getEnvironment().equals(World.Environment.NORMAL)) {
			
			//this is location to spawn the entity
			final Location spawnLoc = event.getWorld().getHighestBlockAt(event.getChunk().getBlock(8, 255 /* not going to spawn it at build height obviously */, 0).getLocation()).getLocation();
			
			//play sound (this also makes explosion particles)
			event.getWorld().playEffect(spawnLoc, Effect.END_GATEWAY_SPAWN, 0, 200);
			
			//spawn the entity
			final LivingEntity entity = (LivingEntity) event.getWorld().spawnEntity(spawnLoc, EntityType.STRAY);
			
			//make stray fast
			entity.addPotionEffect(PotionEffectType.SPEED.createEffect(1000, 4));
			
			//give stray a cool name
			entity.setCustomName(Utils.christmasifyString("Merry Christmas"));
			entity.setCustomNameVisible(true);
			
			//give the stray a lot of health
			entity.setMaxHealth(1000);
			entity.setHealth(1000);
			
			//set glowing
			entity.setGlowing(true);
			
			/***************************************
			 * spawn with unique book
			 ***************************************/

			final ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
			
			//set book meta data
			final BookMeta bm = (BookMeta) book.getItemMeta();
			bm.setAuthor("oldfag.org");
			
			final String title = Utils.christmasifyString("Merry Christmas");
			bm.setDisplayName(title);
			bm.setTitle(title);
			bm.setLore(Arrays.asList(Christmas2020.FORMAT.format(new Date()), String.valueOf(rand.nextInt(10000))));
			bm.addPage("Thank you for playing on my christian server! Merry Christmas from John200410");
			book.setItemMeta(bm); //updates the itemstack meta
			
			entity.getEquipment().setItemInOffHand(book);
			entity.getEquipment().setItemInOffHandDropChance(1f); //makes book always drop
		}
	}

	@EventHandler
	private void onChatSent(AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		p.setDisplayName(Utils.colorFor(p.getUniqueId()) + p.getDisplayName() + ChatColor.RESET); //christmas color name
	}
}
