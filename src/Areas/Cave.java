package Areas;

import General.Room;
import Enemies.Boss;
import Enemies.Minion;
import General.Item;

public class Cave {
	
	//instance variables
	private String areaName = "Cave";
	private Room[][] rooms;
	
	public Cave(General.Character player)
	{
		
		rooms = new Room[3][3];
		rooms[0][0] = new Room(null, null, null, false);
		rooms[0][1] = new Room(null, null, null, false);
		rooms[0][2] = new Room(null, null, null, true);
		rooms[1][0] = new Room(null, null, null, false);
		rooms[1][1] = new Room(new Boss(1, 1, "Bossy guy"), null, null, false);
		rooms[1][2] = new Room(null, new Minion(1, 1, "Troll"), new Item(1, 1, "[Wizard] Robe"), false);
		rooms[2][0] = new Room(null, null, null, true);
		rooms[2][1] = new Room(null, new Minion(1, 1, "Troll"), new Item(1, 1, "[Thief] Cape"), false);
		rooms[2][2] = new Room(null, null, null, true);
		
	}
	
	/*
	 * return the number of rooms that the player has discovered
	 * n = columns. m = rows
	 */
	public int getRoomsDiscovered() {
		int totalDiscovered = 0;
		for (int m = 0; m < 4; m++) {
			for (int n = 0; n < 4; n++) {
				if (rooms[m][n].isDiscovered())
					totalDiscovered++;
			}
		}
		return totalDiscovered;
	}
	
	public void room1()
	{
		System.out.println("You enter the Cave and find an empty room. The room has two doorways, one " +
		"directly across from where you entered and one off to the right. Somehwere further into the cave " +
		"you hear a menacing voice \"YOU DARE ENTER MY LAIR? TURN BACK NOW OR FACE CERTAIN DEATH!\"");
	}

}
