package General;

import java.util.Scanner;

import javax.swing.SwingUtilities;

import Areas.Cave;
import Areas.City;
import Areas.Woods;
import Enemies.Boss;
import Enemies.Minion;

public class Core {

	/*
	 * initialize variables
	 */
	private Scanner keyboard;
	private Woods woods;
	private City city;
	private Cave cave;
	private Character player;

	public Core(General.Character player) {

		/*
		 * instantiate necessary variables
		 */
		this.player = player;


		/*
		 * create 3 different areas. Each contains 9 rooms
		 */

		 // create starting point (the village)
		 // TODO create starting town
		
		 // create area #1 (wood)
		 woods = new Woods();
		
		 // create area #2 (cave)
		 cave = new Cave(player);
		
		 // create area #3 (city)
		 city = new City();
		
		// start game engine
		gameEngine();
	}

	/*
	 * the method which keeps the game running while maintaining functionalities
	 * also does any calculations necessary
	 */
	public void gameEngine() {

		// initialize & instantiate variables
		keyboard = new Scanner(System.in);
		
		// introduce game objective
		System.out.println("Welcome to TextAdventure!");
		System.out.println(
				"The game contains 3 areas: Woods, Cave, and City. Each area has 9 Rooms. One of those rooms "
				+ "contains a Boss which you can attempt to kill. If you succeed in killing each area's boss, "
				+ "you will have the chance to face the game's final boss located in a volcano. Once defeated, "
				+ "you win the game.");
		System.out.println("Furthermore, each room of each area contains different things. "
				+ "You may perhaps encounter a minion in one room, or maybe find a potion in another. "
				+ "Rooms can also be empty. ");
		
		// player chooses area	
		pickArea:
		System.out.println("There are three areas you can enter: \n(1) Woods \n(2) Cave \n(3) City");
		System.out.println("Which area would you like to enter?");
		
		int chosen = keyboard.nextInt();
		
			if(chosen == 1) {		
				//enterWoods:
					woods.startWoods();
					
			} else if (chosen == 2) {
				//enterCave:
					// start the cave adventure
					cave.room1();
					
			} else if (chosen == 3) {
				enterCity:
					// start the city adventures
					city.crossroads();
				
			}
					
	
	}
	
	// method that handles the fighting between player and boss
	public void fightEnemy(Boss boss) {
		
		String command;
		
		System.out.println("You can either type 'attack' or 'flee'. \nBoss battle starting...");
		
		do {
			
			System.out.println("Either type 'attack' or 'flee'");
			command = keyboard.next();
			
			// player deals damage to boss
			boss.setHealth(boss.getHealth() - player.getAttack());
			System.out.println("You dealt " + player.getAttack() + " damage to the boss. The boss's health is now " + boss.getHealth() + ".");
			
			// check if boss is dead after dealing damage to him
			if (boss.getHealth() <= 0) {
				System.out.println("You defeated the boss!");
				boss.setAlive(false);
				return;
			}
			
			// enemy deals damage to you
			player.setHealth(player.getHealth() - boss.getAttack());
			System.out.println("Boss hit you for " + boss.getAttack() + " damage. Your health is now " + player.getHealth() + ".");
			
		} while (!command.equalsIgnoreCase("flee"));
		
	}
	
	// method that handles the fighting between player and minions
	public void fightEnemy(Minion minion) {
		
		
		
	}
	
}
