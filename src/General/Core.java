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

		// // while the first area isn't clean, keep looping
		// while (areas.get(0).getBoss().isAlive()) {
		// // TODO area #1 gameplay
		// }
		//
		// // while the second area isn't clean, keep looping
		// while (areas.get(1).getBoss().isAlive()) {
		// // TODO area #2 gameplay
		// }
		//
		// // while the third area isn't clean, keep looping
		// while (areas.get(2).getBoss().isAlive()) {
		// // TODO area #3 gameplay
		// }
		//
		// // while the first area isn't clean, keep looping
		// while (areas.get(3).getBoss().isAlive()) {
		// // TODO area #4 gameplay
		// }
		//
		// // while the first area isn't clean, keep looping
		// while (areas.get(4).getBoss().isAlive()) {
		// // TODO area #5 gameplay
		// }

	}

	// method that appends text to the text area
	public void appendMessage(String s) {
		game.getTextArea_displayEvents().append("> " + s + "\n");
	}

}
