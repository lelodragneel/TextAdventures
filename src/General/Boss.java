package General;

public class Boss {

	/*
	 * initialize variables
	 */
	private int health;
	private int attack;
	private String name;
	private boolean alive;

	public Boss(int health, int attack, String name) {
		this.health = health;
		this.attack = attack;
		this.name = name;
		setAlive(true);
	}

	// get methods
	public int getHealth() {
		return health;
	}

	public int getAttack() {
		return attack;
	}

	public String getName() {
		return name;
	}

	// set methods
	public void setHealth(int health) {
		this.health = health;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public void setName(String name) {
		this.name = name;
	}

	// return the alive
	public boolean isAlive() {
		return alive;
	}

	// set the alive
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
