package org.oldfag.christmas.packet;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.nbt.NbtBase;

import java.util.List;

public class WrapperPlayServerMapChunk extends AbstractPacket {
	public static final PacketType TYPE = PacketType.Play.Server.MAP_CHUNK;
	
	public WrapperPlayServerMapChunk() {
		super(new PacketContainer(TYPE), TYPE);
		handle.getModifier().writeDefaults();
	}
	
	public WrapperPlayServerMapChunk(PacketContainer packet) {
		super(packet, TYPE);
	}
	
	/**
	 * Retrieve Chunk X.
	 * <p>
	 * Notes: chunk X coordinate
	 *
	 * @return The current Chunk X
	 */
	public int getChunkX() {
		return handle.getIntegers().read(0);
	}
	
	/**
	 * Set Chunk X.
	 *
	 * @param value - new value.
	 */
	public void setChunkX(int value) {
		handle.getIntegers().write(0, value);
	}
	
	/**
	 * Retrieve Chunk Z.
	 * <p>
	 * Notes: chunk Z coordinate
	 *
	 * @return The current Chunk Z
	 */
	public int getChunkZ() {
		return handle.getIntegers().read(1);
	}
	
	/**
	 * Set Chunk Z.
	 *
	 * @param value - new value.
	 */
	public void setChunkZ(int value) {
		handle.getIntegers().write(1, value);
	}
	
	/**
	 * Retrieve Ground-Up continuous.
	 * <p>
	 * Notes: this is True if the packet represents all sections in this
	 * vertical column, where the primary bit map specifies exactly which
	 * sections are included, and which are air
	 *
	 * @return The current Ground-Up continuous
	 */
	public boolean getGroundUpContinuous() {
		return handle.getBooleans().read(0);
	}
	
	/**
	 * Set Ground-Up continuous.
	 *
	 * @param value - new value.
	 */
	public void setGroundUpContinuous(boolean value) {
		handle.getBooleans().write(0, value);
	}
	
	/**
	 * Bitmask with bits set to 1 for every 16×16×16 chunk section whose data is
	 * included in Data. The least significant bit represents the chunk section at
	 * the bottom of the chunk column (from y=0 to y=15).
	 * @return the bitmask
	 */
	public int getBitmask() {
		return handle.getIntegers().read(2);
	}
	
	public void setBitmask(int value) {
		handle.getIntegers().write(2, value);
	}
	
	/**
	 * See <a href="http://wiki.vg/Chunk_Format#Data_structure">the wiki</a>
	 * @return the data array
	 */
	public byte[] getData() {
		return handle.getByteArrays().read(0);
	}
	
	public void setData(byte[] value) {
		handle.getByteArrays().write(0, value);
	}
	
	/**
	 * @return all block entities in the chunk
	 */
	public List<NbtBase<?>> getTileEntities() {
		return handle.getListNbtModifier().read(0);
	}
	
	public void setTileEntities(List<NbtBase<?>> value) {
		handle.getListNbtModifier().write(0, value);
	}
}