package Areas;
import java.util.ArrayList;

import Creatures.Boss;
import Creatures.Minion;

public class Area {

	/*
	 * initialize variables
	 */
	private Boss boss;
	private String puzzle;
	private String areaName;
	private ArrayList<Minion> minions;

	public Area(String areaName, Boss boss) {
		
		this.areaName = areaName;
		this.boss = boss;
		minions = new ArrayList<Minion>();
		
		// create 4 minions for this area with the same health and attack values
		for (int i = 0; i < 5; i++)
			minions.add(new Minion(40, 5, "minion #" + (i + 1)));
		
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
