package Enemies;

public class Minion extends Enemy{

	/*
	 * initialize variables
	 */

	public Minion(int health, int attack, String name) {
		
		this.health = health;
		this.attack = attack;
		this.name = name;
		alive = true;
		
	}
	
}
