package Areas;

import java.util.ArrayList;

import General.Room;

public abstract class Area {

	/*
	 * initialize variables
	 */
	private String areaName;
	private ArrayList[][] location;

	public Area() {

		// create a 3 X 3 matrix to represent the locations of the area
		// let m be the row number. let n be the column number
		location[0][0].add(new Room(null, null, null));
		
		
	}

}
