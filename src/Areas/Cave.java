package Areas;

import General.Room;
import Enemies.Boss;
import Enemies.Minion;
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
		rooms[1][1] = new Room(new Boss(1, 1, "Bossy guy"), null, null, false);
		rooms[1][2] = new Room(null, new Minion(1, 1, "Troll"), new Item(1, 1, "[Wizard] Robe"), false);
		rooms[2][0] = new Room(null,null, null, true);
		rooms[2][1] = new Room(null, new Minion(1, 1, "Troll"), new Item(1, 1, "[Thief] Cape"), false);
		rooms[2][2] = new Room(null, null, null, true);
	}
	
}
