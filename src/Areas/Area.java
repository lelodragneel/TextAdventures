package Areas;
import java.util.ArrayList;

import Creatures.Boss;
import Creatures.Minion;

public abstract class Area {

	/*
	 * initialize variables
	 */
	private Boss boss;
	private String puzzle;
	private String areaName;
	private ArrayList<Minion> rooms;

	public Area(String areaName, Boss boss) {
		
		this.areaName = areaName;
		this.boss = boss;
		rooms = new ArrayList<Minion>();
		
		// create a 3 X 3 matrix to represent the locations of the area
		for (int i = 0; i < 5; i++)
			rooms.add(new Minion(40, 5, "minion #" + (i + 1)));
		
		// TODO create incrementally stronger minions 
		// TODO create a puzzle for areas
	}

	// get methods
	public Boss getBoss() {
		return boss;
	}

	public String getPuzzle() {
		return puzzle;
	}

	// set methods
	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	public void setPuzzle(String puzzle) {
		this.puzzle = puzzle;
	}
}
