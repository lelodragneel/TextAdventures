package General;

public class Character {
	
	private String name;
	private int health;
	private int attack;
	private int potions;
	private String type;

	public Character(String type, String name, int health, int attack, int potions) {
		this.type = type;
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.potions = potions;
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

}
