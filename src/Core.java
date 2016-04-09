import java.util.ArrayList;

import javax.swing.SwingUtilities;

import Areas.Area;
import Creatures.Boss;

public class Core {

	/*
	 * initialize variables
	 */
	private GamePanel game;
	private ArrayList<Area> areas;
	
	public Core() {
		
		/*
		 * create the game frame
		 */
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				game = new GamePanel();
			}
		});
		
		/*
		 * instantiate variables,
		 * and create 5 different areas. Each contains 4 minions and one boss
		 */
		areas = new ArrayList<Area>();
		// create area #1
		areas.add(new Area("Woods", new Boss(100, 10, "AngryTree")));
		// create area #2
		areas.add(new Area("Desert", new Boss(150, 14, "Renekton")));
		// create area #3
		areas.add(new Area("Cave", new Boss(210, 18, "Kog")));
		// create area #4
		areas.add(new Area("Forest", new Boss(300, 25, "Ragno")));
		// create area #5
		areas.add(new Area("Volcano", new Boss(420, 35, "LavaSkeleton")));
		
		// start game engine
		gameEngine();
	}
	
	/*
	 * the method which keeps the game running while maintaining functionalities
	 * also does any calculations necessary
	 */
	public void gameEngine() {
		
//			// while the first area isn't clean, keep looping
//			while (areas.get(0).getBoss().isAlive()) {
//				// TODO area #1 gameplay
//			}
//					
//			// while the second area isn't clean, keep looping
//			while (areas.get(1).getBoss().isAlive()) {
//				// TODO area #2 gameplay
//			}
//						
//			// while the third area isn't clean, keep looping
//			while (areas.get(2).getBoss().isAlive()) {
//				// TODO area #3 gameplay
//			}
//						
//			// while the first area isn't clean, keep looping
//			while (areas.get(3).getBoss().isAlive()) {
//				// TODO area #4 gameplay
//			}
//						
//			// while the first area isn't clean, keep looping
//			while (areas.get(4).getBoss().isAlive()) {
//				// TODO area #5 gameplay
//			}

	}
	
	// method that appends text to the text area
	public void appendMessage(String s) {
		game.getTextArea_displayEvents().append("> " + s + "\n");
	}
	
}
