package org.oldfag.christmas;

import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

/**
 * @author John200410 12/18/2020 for christmas
 */
public class Utils {
	
	/**
	 * good colors
	 */
	public final static List<ChatColor> CHRISTMAS_COLORS = Arrays.asList(ChatColor.DARK_RED, ChatColor.RED, ChatColor.WHITE, ChatColor.GREEN, ChatColor.DARK_GREEN);
	
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
