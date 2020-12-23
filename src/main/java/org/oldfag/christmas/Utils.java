package org.oldfag.christmas;

import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author John200410 12/18/2020 for christmas
 * @author charlie353535 23/12/2020
 */
public class Utils {

	/**
	 * good colors
	 */
	public final static List<ChatColor> CHRISTMAS_COLORS = Arrays.asList(ChatColor.DARK_RED, ChatColor.RED /*, ChatColor.WHITE*/ , ChatColor.GREEN, ChatColor.DARK_GREEN);

	/**
	 * @param id UUID of player
	 * @return Colour that they should have
	 */
	public static ChatColor colorFor(UUID id) {
		int idx = Math.abs(id.hashCode() % CHRISTMAS_COLORS.size());
		return CHRISTMAS_COLORS.get(idx);
	}

	/**
	 * adds christmas colors to string
	 *
	 * @param input string to turn into christmas lights
	 * @return cooler string
	 */
	public static String christmasifyString(String input) {
		//string builder
		final StringBuilder sb = new StringBuilder();
		
		//current character we are at
		int offset = 0;
		
		for (char character : input.toCharArray()) {
			sb.append(CHRISTMAS_COLORS.get(offset % CHRISTMAS_COLORS.size())).append(character);
			
			//increase offset
			offset++;
		}
		
		return sb.toString();
	}
	
}
