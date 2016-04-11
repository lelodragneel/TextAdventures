package Areas;

import General.Room;
import Enemies.Boss;
import Enemies.Minion;
import General.Item;
import General.Core;

public class Cave {
	
	//instance variables
	private String areaName = "Cave";
	private Room[][] rooms;
	private Core core;
	

	public Cave(General.Character player, Core core) {
		this.core = core;
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
	
	//The rooms
	public void room1()
	{
		System.out.println("You enter the Cave and find an empty room. The room has two doorways, one " +
		"directly across from where you entered and one off to the right. Somehwere further into the cave " +
		"you hear a menacing voice \"YOU DARE ENTER MY LAIR? TURN BACK NOW OR FACE CERTAIN DEATH!\"");
	}

	public void room2()
	{
		System.out.println("You run into another empty room. There are another 2 doorways to choose from. There is a doorway straight ahead " +
		" and another off to the right. A loud voice comes from the doorway on the right, \"Come this way traveller. FACE ME IF YOUR DARE!\"");
	}
	public void room3()
	{
		System.out.println("You spot a potion in the corner and pick it up.");
		
		System.out.println("There is a doorway on the right giving off a foul stench.");
	}
	public void room4()
	{
		if(rooms[1][2].getMinion().isAlive())
		{
			System.out.println("You walk into the room and a troll appears out of the darkness. He challenges you and carnage ensues!");
			core.fightEnemy(rooms[1][2].getMinion());
		}
		System.out.println("There is a doorway on the right from which you hear a voice \"Come adventurer, don't be scared.\"");
		
	}
	public void room5()
	{
		System.out.println("The doorway leads to another empty room with a doorway to the left and straight ahead. From the left a voice taunts " +
		"\"Come here! Allow me to introduce myself!\"");
	}
	public void room6()
	{
		System.out.println("You find a potion wedges into a crack in the wall.");
		
		System.out.println("There is a doorway to the left. Other than that back is the only option.");
	}
	public void room7()
	{
		if(rooms[2][1].getMinion().isAlive())
		{
		System.out.println("A troll wakes up from its slumber as you walk through the doorway. It prepares itself to charge!");
		core.fightEnemy(rooms[1][2].getMinion());
		}
		System.out.println("From the left you hear a voice scream as you defeat the troll \"HOW DARE YOU KILL MY BRETHEREN. COME HERE SO I MAY TAKE REVENGE!\"" +
		"There is also a hole straight ahead that appears to lead to another open area.");
	}
	public void room8()
	{
		
		System.out.println("You see a skeleton of a body sitting in the far corner. It holds a note and beside it lays a potion." +
		" The note reads \"There is no way out. Here is where I stay for fear that the troll kill will eat me alive...\"");
		System.out.println("The only way to go is back.");
	}
	public void room9()
	{
		System.out.println("As you enter the room a massive troll appears waiting for you to arrive.");
		System.out.println("\" At last you have come! Now come here so I can make soup out of you! Just as I did with that weak little village!\"");
		core.fightEnemy(rooms[1][1].getBoss());
		System.out.println("After killing the troll you feel somehow stronger. You leave the cave in search of the other horrible monsters.");
	}
	
	//Get room to allow game engine to access minions and potions
	public Room getRoom(int r, int c)
	{
		return rooms[r][c];
	}
	
}
