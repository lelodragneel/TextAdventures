package General;

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
	private GamePanel game;
	private Woods woods;
	private City city;
	private Cave cave;
	private Character player;

	public Core(General.Character player) {

		/*
		 * instantiate necessary variables
		 */
		this.player = player;
		game = new GamePanel();


		/*
		 * create 3 different areas. Each contains 9 rooms
		 */

		 // create starting point (the village)
		 // TODO create starting town
		
		 // create area #1 (wood)
		 woods = new Woods(player);
		
		 // create area #2 (city)
		 // TODO create second area
		
		 // create area #3 (cave)
		 // TODO create third area
		
		// start game engine
		gameEngine();
	}

	/*
	 * the method which keeps the game running while maintaining functionalities
	 * also does any calculations necessary
	 */
	public void gameEngine() {

		// introduce game objective
		game.appendMessage("Welcome to TextAdventure!");
		game.appendMessage(
				"The game contains 3 areas: Woods, Cave, and City. Each area has 9 Rooms. One of those rooms "
				+ "contains a Boss which you can attempt to kill. If you succeed in killing each area's boss, "
				+ "you will have the chance to face the game's final boss located in a volcano. Once defeated, "
				+ "you win the game.");
		game.appendMessage("Furthermore, each room of each area contains different things. "
				+ "You may perhaps encounter a minion in one room, or maybe find a potion in another. "
				+ "Rooms can also be empty. ");
		
		// player chooses area
		game.appendMessage("");
		
		
		
	}
	
	// method that handles the fighting between player and boss
	public void fightEnemy(Boss boss) {
		// TODO fight calculations
	}
	
	// method that handles the fighting between player and minions
	public void fightEnemy(Minion minion) {
		// TODO fight calculations
	}
	
}
