package Enemies;

public class Boss extends Enemy{

	/*
	 * initialize variables
	 */

	public Boss(int health, int attack, String name) {
		
		this.health = health;
		this.attack = attack;
		this.name = name;
		alive = true;
		
	}

}
