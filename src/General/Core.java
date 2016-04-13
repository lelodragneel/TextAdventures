package General;

import java.util.Scanner;

import Areas.Cave;
import Areas.City;
import Areas.Woods;
import Enemies.Boss;
import Enemies.Enemy;
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
		 * create 3 different areas
		 * Cave & City have 9 rooms
		 * Woods is a maze
		 */			
		 // create area #1 (cave)
		 cave = new Cave(this);
		
		 // create area #2 (city)
		 city = new City(this);
		 
		 // create area #3 (wood)
		 //woods = new Woods();
		
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
		System.out.println("Welcome " + player.getName() + " to the world of Alera. You are an adventurer who has returned to their home village.");
		System.out.println("This morning you went to the woods to gather fire wood for your home. \nHowever, when you returned to the village you found the houses on fire.");
		System.out.println("Going through the village you see all the villagers have been killed and their homes destroyed. \nArriving to the center of town you see the mayor bleeding on the ground.");
		System.out.println("Rushing to him you see he is still alive.Helping him sit up he begins to speak.");
		System.out.println("*Cough* *Cough* " + player.getName() + " it was horrible these four monsters attacked the village.\nThey kept asking where you were! No one told them so they destroyed the village!\nYou must flee this place! Get as far away as possible!");
		System.out.println("With this last message the mayor stops breathing.\nInstead of leaving as the mayor said you follow the trail of destruction heading away from the village.");
		
		System.out.println(
				"\nThe game contains 3 areas: Cave, City, and Woods. The Cave and City have 9 Rooms. Every one of those areas "
				+ "contain a Boss which you can attempt to kill. \nIf you succeed in killing the Cave and City's boss, "
				+ "you will have the chance to face the game's final boss located somewhere in the woods. Once defeated, "
				+ "you win the game.");
		System.out.println("\nFurthermore, each room of each area contains different things. "
				+ "You may perhaps encounter a minion in one room, or maybe find a potion in another. "
				+ "Rooms can also be empty. ");
		
		// let the player chose an area to enter
		chooseArea();

	}
	
	// player picks an area to enter
	public void chooseArea() {
		
		// inform the player which bosses are defeated
		System.out.println("Here are the Cave and City's boss conditions:");
		if(cave.getRoom(1, 1).getBoss().isAlive())
			System.out.println("	Cave Boss: Alive");
		else
			System.out.println("	Cave Boss: Dead");
		if(city.getRoom(1, 1).getBoss().isAlive())
			System.out.println("	City Boss: Alive");
		else
			System.out.println("	City Boss: Dead");
		
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
			
			// check if player can enter the woods
			if(!cave.getRoom(1, 1).getBoss().isAlive() && !city.getRoom(1, 1).getBoss().isAlive()) {
				System.out.println("Alright, both other bosses are defeated. You may enter the woods! \nThe woods is a confusing maze of different paths you can take. Best of luck finding the final boss.");
				// start the city adventures
				woods.startWoods();
				
			} else {
				System.out.println("In order to enter the woods and have a chance to kill the final boss, you must kill the two bosses found in Cave and City.");
				chooseArea();
			}
		} 
	}
	
	// print player stats/information/progress 
	public void displayInfo() {
		
		System.out.println("------------------------------------------------");
		System.out.println("|                  All the Info!               |");
		System.out.println("------------------------------------------------");
		System.out.println("Player Stats:");
		System.out.println("	Health:");
		System.out.println("	Attack:");
		System.out.println("Progression:");
		System.out.println("	Current Area:");
		System.out.println("	Rooms Discovered:");
		System.out.println("	Boss Status:");
		System.out.println("------------------------------------------------");
		
	}
	

	// method that handles the fighting between player and minions/bosses
	public void fightEnemy(Enemy enemy) {
		
		// inform user enemy type
		if (enemy instanceof Minion) {
			System.out.println("You encountered a [Minion]");
		}
		if (enemy instanceof Boss) {
			System.out.println("You encountered a [Boss]");
		}
		
		// possibility of missing your opponent
		int missedTarget=(int) (Math.random()*4)+1;

		String command;

		System.out.println("Battle with " + enemy.getName() + " is starting...");

		while (true) {
			
			if(player.getHealth()>0){
			System.out.println("Type 'attack': ");
			command = keyboard.next();

				if (command.equalsIgnoreCase("attack")) {
	
					// player deals damage to boss
					//If randomly generated number is not 2, the player successfully damages the boss.
					if(missedTarget!=2){
						enemy.setHealth(enemy.getHealth() - player.getAttack());
						System.out.println("You dealt " + player.getAttack() + " damage to " + enemy.getName() + "." + enemy.getName() + "'s health is now "
								+ enemy.getHealth() + ".");
					}
					//Otherwise, the player misses and does no damage for that turn.
					else{
						System.out.println(enemy.getName() + " dodged your attack! His health remains at " + enemy.getHealth() + ".");
					}
	
					// check if boss is dead after dealing damage to him
					if (enemy.getHealth() <= 0) {
						System.out.println("You defeated " + enemy.getName() + "!");
						enemy.setAlive(false);
						return;
					}
					
					//A new random number is assigned to missedTarget
					missedTarget=(int) (Math.random()*4)+1;
	
					// enemy deals damage to you
					//If randomly generated number is 1 or 2, the minion successfully damages the player.
					if(missedTarget<3){
						player.setHealth(player.getHealth() - enemy.getAttack());
						System.out.println(enemy.getName() + " hit you for " + enemy.getAttack() + " damage. Your health is now "
								+ player.getHealth() + "/" + player.getMaxHealth() + ".");
					}
					//Otherwise, the minion misses and does no damage for that turn.
					else{
						System.out.println("You dodge " + enemy.getName() + "'s attack! Your health remains at " + player.getHealth() + "/" + player.getMaxHealth() + ".");
					}
					
					//A new random number is assigned to missedTarget
					missedTarget=(int) (Math.random()*4)+1;
 
				}
			}
			// check if player is dead
			else {
				if (player.getPotions() > 0) {
					player.setPotions(player.getPotions() - 1);
					player.setHealth(player.getMaxHealth());
					System.out.println(
							"You consumed a health potion right before your death, and you recovered your full health back to " + player.getHealth() + "/" + player.getMaxHealth() + ". \nYou now have "
									+ player.getPotions() + " health potions left.");

				}
				else{ 
					System.out.println("You died. The game is over. And you thought Dark Souls II was bad, haha\n");
					chooseArea();
				}
			}		
		}
	}


	// return the player object
	public Character getPlayer() {
		return player;
	}
	
}
