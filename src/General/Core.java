package General;

import javax.swing.SwingUtilities;

import Areas.Cave;
import Areas.City;
import Areas.Woods;

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
		
		/*
		 * create the game frame
		 */
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				game = new GamePanel();
			}
		});

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

		

	}

	// method that appends text to the text area
	public void appendMessage(String s) {
		game.getTextArea_displayEvents().append("> " + s + "\n");
	}

}
