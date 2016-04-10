package Areas;

import General.Room;
import General.Minion;
import General.Boss;
import General.Item;

public class Cave extends Area {
	
	//instance variables
	private String areaName = "Cave";
	private Room[][] rooms;
	
	public Cave()
	{
		rooms = new Room[3][3];
		rooms[0][0] = new Room(null, null, null, false);
		rooms[0][1] = new Room(null, null, null, true);
		rooms[0][2] = new Room(null, null, null, false);
		rooms[1][0] = new Room(null, null, null, false);
		rooms[1][1] = new Room(null, null, null, false);
		rooms[1][2] = new Room(null, new Minion(1, 1, "Troll"), null, false);
		rooms[2][0] = new Room(null,null, null, false);
		rooms[2][1] = new Room(null, null, null, false);
		rooms[2][2] = new Room(null, null, null, false);
	}
	
}
