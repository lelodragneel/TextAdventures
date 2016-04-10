package General;

public class Minion {

	/*
	 * initialize variables
	 */
	private double health;
	private double attack;
	private String name;
	private boolean alive;

	public Minion(double health, double attack, String name) {
		this.health = health;
		this.attack = attack;
		this.name = name;
		setAlive(true);
	}

	// get methods
	public double getHealth() {
		return health;
	}

	public double getAttack() {
		return attack;
	}

	public String getName() {
		return name;
	}

	// set methods
	public void setHealth(double health) {
		this.health = health;
	}

	public void setAttack(double attack) {
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
