package General;

import java.util.ArrayList;

public class Character {

	private String name;
	private int health;
	private int attack;
	private int potions;
	private String type;
	private ArrayList<Item> inventory;

	public Character(String type, String name, int health, int attack, int potions) {
		this.type = type;
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.potions = potions;
		inventory = new ArrayList<Item>();
	}

	// get methods
	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getAttack() {
		return attack;
	}

	public int getPotions() {
		return potions;
	}

	// set methods
	public void setName(String name) {
		this.name = name;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public void setPotions(int potions) {
		this.potions = potions;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	//method to find potion
	public void findPotion(){
		potions++;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
}
