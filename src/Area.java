import java.util.ArrayList;

import Creatures.Boss;
import Creatures.Minion;

public class Area {

	/*
	 * initialize variables
	 */
	private Boss miniBoss;
	private String puzzle;
	private String areaName;
	private ArrayList<Minion> minions;

	public Area(String areaName, Boss miniBoss) {
		
		this.areaName = areaName;
		this.miniBoss = miniBoss;
		minions = new ArrayList<Minion>();
		
		// create 4 minions for this area with the same health and attack values
		for (int i = 0; i < 5; i++)
			minions.add(new Minion(40, 5, "minion #" + (i + 1)));
		
		// TODO create incrementally stronger minions 
		// TODO create a puzzle for areas
	}

	// get methods
	public Boss getMiniBoss() {
		return miniBoss;
	}

	public String getPuzzle() {
		return puzzle;
	}

	// set methods
	public void setMiniBoss(Boss miniBoss) {
		this.miniBoss = miniBoss;
	}

	public void setPuzzle(String puzzle) {
		this.puzzle = puzzle;
	}
}
