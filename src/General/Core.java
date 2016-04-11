package General;

import java.util.Scanner;

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
			
		 // create area #1 (cave)
		 cave = new Cave(this);
		
		 // create area #2 (city)
		 city = new City(this);
		 
		 // create area #3 (wood)
		 woods = new Woods();
		
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
		System.out.println("Welcome [insert name] to the world of Alera. You are an adventure who has returned to their home village.");
		System.out.println("This morning you went to the woods to gather fire wood for your home. \nHowever, when you returned to the village you found the houses on fire.");
		System.out.println("Going through the village you see all the villagers have been killed and their homes destroyed. \nArriving to the center of town you see the mayor bleeding on the ground.");
		System.out.println("Rushing to him you see he is still alive.Helping him sit up he begins to speak.");
		System.out.println("*Cough* *Cough* [insert name] it was horrible these four monsters attacked the village.\nThey kept asking where you were! No one told them so they destroyed the village!\nYou must flee this place! Get as far away as possible!");
		System.out.println("With this last message the mayor stops breathing.\nInstead of leaving as the mayor said you follow the trail of destruction heading away from the village.");
		
		System.out.println(
				"The game contains 3 areas: Cave, City, and Woods. The Cave and City have 9 Rooms. Every one of those rooms "
				+ "contain a Boss which you can attempt to kill. If you succeed in killing the Cave and City's boss, "
				+ "you will have the chance to face the game's final boss located somewhere in the woods. Once defeated, "
				+ "you win the game.");
		System.out.println("Furthermore, each room of each area contains different things. "
				+ "You may perhaps encounter a minion in one room, or maybe find a potion in another. "
				+ "Rooms can also be empty. ");
		
		// player chooses area	
		System.out.println("There are two areas you can enter: \n(1) Cave \n(2) City \n(3) Woods");
		System.out.println("Which area would you like to enter?");
		
		int chosen = keyboard.nextInt();

		if (chosen == 1) {
			// start the cave adventure
			cave.room1();

		} else if (chosen == 2) {
			// start the city adventure
			city.room1();

		} else if (chosen == 3) {
			if(!cave.getRoom(1, 1).getBoss().isAlive() && !city.getRoom(1, 1).getBoss().isAlive()) {
				System.out.println("Alright, both other bosses are defeated. You may enter the woods!");
				// start the city adventures
				woods.startWoods();
				
			} else 
				System.out.println("In order to enter the woods and have a chance to kill the final boss, you must kill the two bosses found in Cave and City.");

		} 
					
	}
	
	// method that handles the fighting between player and boss
	public void fightEnemy(Boss boss) {

		String command;
      
		System.out.println("Boss battle starting...");

		while (true) {

			System.out.println("Type 'attack': ");
			command = keyboard.next();

			if (command.equalsIgnoreCase("attack")) {

				// player deals damage to boss
				boss.setHealth(boss.getHealth() - player.getAttack());
				System.out.println("You dealt " + player.getAttack()
						+ " damage to the boss. The boss's health is now "
						+ boss.getHealth() + ".");

				// check if boss is dead after dealing damage to him
				if (boss.getHealth() <= 0) {
					System.out.println("You defeated the boss!");
					boss.setAlive(false);
					return;
				}

				// enemy deals damage to you
				player.setHealth(player.getHealth() - boss.getAttack());
				System.out.println("Boss hit you for " + boss.getAttack()
						+ " damage. Your health is now " + player.getHealth()
						+ ".");

				// check if player is dead
				if (player.getHealth() <= 0)
					System.out
							.println("You died. The game is over. And you thought Dark Souls II was bad, haha");
				return;

			}
		}

	}
	
	// method that handles the fighting between player and minions
	public void fightEnemy(Minion minion) {

		String command;

		System.out.println("Minion battle starting...");

		while (true) {

			System.out.println("Type 'attack': ");
			command = keyboard.next();

			if (command.equalsIgnoreCase("attack")) {

				// player deals damage to boss
				minion.setHealth(minion.getHealth() - player.getAttack());
				System.out.println("You dealt " + player.getAttack()
						+ " damage to the boss. The boss's health is now "
						+ minion.getHealth() + ".");

				// check if boss is dead after dealing damage to him
				if (minion.getHealth() <= 0) {
					System.out.println("You defeated the boss!");
					minion.setAlive(false);
					return;
				}

				// enemy deals damage to you
				player.setHealth(player.getHealth() - minion.getAttack());
				System.out.println("Boss hit you for " + minion.getAttack()
						+ " damage. Your health is now " + player.getHealth()
						+ ".");

				// check if player is dead
				if (player.getHealth() <= 0)
					System.out
							.println("You died. The game is over. And you thought Dark Souls II was bad, haha");
				return;
			}
		}

	}
	
	// return the player object
	public Character getPlayer() {
		return player;
	}
	
}
