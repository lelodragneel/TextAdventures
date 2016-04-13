package General;

import java.util.ArrayList;

public class Character {

	private String name;
	private int health;
	private int maxHealth;
	private int attack;
	private int potions;
	private String type;
	private ArrayList<Item> inventory;

	public Character(String type, String name, int maxHealth, int attack, int potions) {
		this.type = type;
		this.name = name;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
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
	
	// add loot to the player's inventory and increase stats based on the item bonus
	public void addToInventory(Item item) {
		
		inventory.add(item);
		System.out.println("You picked up " + item.getItemName() + "!");
		
		// check if the looted item increases health
		if (item.getHealthIncrease() > 0) {
			maxHealth += item.getHealthIncrease();
			System.out.println("Your maximum health has increased from " + (maxHealth - item.getHealthIncrease()) + " to " + maxHealth + ".");
			// increase player's current health by half the increased health
			health += item.getHealthIncrease()/2;
			// make sure the player's health doesn't go over the limit
			if (health > maxHealth) 
				health = maxHealth;	
			System.out.println("Your health is now " + health + "/" + maxHealth + ".");
		}
		
		// check if the looted item increases attack
		if (item.getDamageIncrease() > 0) {
			attack += item.getDamageIncrease();
			System.out.println("Your attack damage has increased from  " + (attack - item.getDamageIncrease()) + " to " + attack + ".");
		}
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
}
