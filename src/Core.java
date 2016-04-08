import java.util.ArrayList;

import javax.swing.SwingUtilities;

import Creatures.Boss;

public class Core {

	/*
	 * initialize variables
	 */
	private ArrayList<Area> areas = new ArrayList<Area>();
	
	public Core() {
		
		/*
		 * create the game frame
		 */
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GamePanel();
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
		
	}
}
