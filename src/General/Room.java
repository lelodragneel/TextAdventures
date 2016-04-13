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
	
	/*
	 * constructor
	 * the type could be:
	 * 		empty = nothing in the room
	 * 		boss = the room has the final boss which drops the key
	 * 		minion = the room has a minion you can fight for potential loot
	 */
	public Room(Boss boss, Minion minion, Item item, boolean potion) {
		this.boss = boss;
		this.item = item;
		this.minion = minion;
		this.potion = potion;
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
	public Minion getMinion()
	{
		return minion;
	}
	public void setMinion(Minion min)
	{
		minion = min;
	}
	public boolean getPotion()
	{
		return potion;
	}
	public void setPotion(boolean p)
	{
		potion = p;
	}
}