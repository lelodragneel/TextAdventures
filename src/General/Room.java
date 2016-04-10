package General;

import Enemies.Boss;
import Enemies.Minion;

public class Room {
	
	/*
	 * initialize variables
	 */
	private Boss boss;
	private Minion minion;
	private Item item;
	private boolean potion;
	private boolean discovered;
	
	/*
	 * constructor
	 * the type could be:
	 * 		empty = nothing in the room
	 * 		boss = the room has the final boss which drops the key
	 * 		minion = the room has a minion you can fight for potential loot
	 */
	public Room(Boss boss, Minion minion, Item item, boolean pot) {
		this.setBoss(boss);
		this.setItem(item);
		this.minion = minion;
		potion = pot;
	}

	public Boss getBoss() {
		return boss;
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public boolean isDiscovered() {
		return discovered;
	}

	public void setDiscovered(boolean discovered) {
		this.discovered = discovered;
	}
	
}
