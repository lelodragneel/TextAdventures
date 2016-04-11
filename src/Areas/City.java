package Areas;

import General.Room;

import java.util.Scanner;

import Enemies.Boss;
import Enemies.Minion;
import General.Item;
import General.Core;

public class City {
	
	//instance variables
	private String areaName = "City";
	private Room[][] rooms;
	private Core core;
	

	public City2(Core core) {
		//use getPlayer method to get the player
		this.core = core;
		rooms = new Room[3][3];
		rooms[0][0] = new Room(null, null, null, false);
		rooms[0][1] = new Room(null, new Minion(1, 1, "Trash Creature"), null, false);
		rooms[0][2] = new Room(null, new Minion(1, 1, "Sneaky Trash Creature"), new Item(1, 1, "[Warrior] Shield"), false);
		rooms[1][0] = new Room(null, new Minion(1, 1, "Trash Creature"), null, false);
		rooms[1][1] = new Room(new Boss(1, 1, "BOSS"), null, null, false);
		rooms[1][2] = new Room(null, null, null, false);
		rooms[2][0] = new Room(null, null, null, false);
		rooms[2][1] = new Room(null, null, null, true);
		rooms[2][2] = new Room(null, null, null, true);
		
	}
	
	//The rooms
	public void room1()
	{
		Scanner keyboard= new Scanner(System.in);
		String direction;
		Boolean directionFound=false;
		System.out.println("\nLooking FORWARD, the city’s wide main street stretches out before you, bathed in shadow from the looming buildings on either side."
				+ "\nTo your RIGHT, a narrower street winds off through a collection of smaller buildings. Lights can be seen in the distance."
				+ "\n Choose your path. Enter r to go right or f to go forward.");
		direction=keyboard.nextLine();
		while(!directionFound){
			if(direction.equals("f")){
				directionFound=true;
				room2();
			}
			else if(direction.equals("r")){
				directionFound=true;
				room5();
			}
			else{
				System.out.println("Command not recognized. Type f for forward, or r for right.");
				direction=keyboard.nextLine();
			}
		}
	}

	public void room2()
	{
		Scanner keyboard = new Scanner(System.in);
		String direction;
		Boolean directionFound;
		System.out.println("You proceed straight ahead. The buildings seem taller from this angle, but also a lot more… run down?");
		System.out.println("Something seems to have driven the city’s inhabitants away…");
		
		if(rooms[0][1].getMinion().isAlive())
		{
			System.out.println("As you stare thoughtfully upward, something grabs you from behind…");
			core.fightEnemy(rooms[0][1].getMinion(), core.getPlayer());
		}
		System.out.println("You sit down on a bit of rubble to recover. Wait... what's that straight ahead?"
				+ "To your right, a loud voice rings out: Come this way traveller. FACE ME IF YOU DARE!"
				+ "\nWill you investigate what lies ahead, or accept the challenge?"
				+ "\nType f to move forward and r to move to your right. To go back to the crossroads, type b.");
		direction=keyboard.nextLine();
		while(!directionFound){
			if(direction.equals("f")){
				directionFound=true;
				room3();
			}
			else if(direction.equals("r")){
				directionFound=true;
				room9();
			}
			else if(direction.equals("b")){
				directionFound=true;
				room1();
			}
			else{
				System.out.println("Command not recognized. Type f for forward, r for right, or b to turn back.");
				direction=keyboard.nextLine();
			}
		}
	}
	public void room3()
	{
		Scanner keyboard= new Scanner(System.in);
		String direction;
		Boolean directionFound=false;
		System.out.println("The street ahead of you is littered with debris. Gingerly, you reach into one of the piles and pull out a SHIELD.");
		if(rooms[0][2].getMinion().isAlive())
		{
			System.out.println("Before you can even investigate what you've found, another creature leaps out from the shadows.");
			core.fightEnemy(rooms[0][2].getMinion(),core.getPlayer());
		}
		
		System.out.println("The path veers off to the right. The only other way to go is backward. "
				+ "\nWhat will you do? Type r to go right or b to go back.");
		direction=keyboard.nextLine();
		while(!directionFound){
			if(direction.equals("r")){
				directionFound=true;
				room4();
			}
			else if(direction.equals("b")){
				directionFound=true;
				room1();
			}
			else{
				System.out.println("Command not recognized. Type r to go right, or b to turn back.");
				direction=keyboard.nextLine();
			}
		}
	}
	public void room4()
	{
		Scanner keyboard=new Scanner(System.in);
		String direction;
		Boolean directionFound=false;
		System.out.println("Concrete buildings block your path in every direction but one."
				+ "The voice speaks again. \"Come adventurer, don't be scared.\""
				+ "\nSteeling yourself, you make a decision. Will you move to the right and face the boss? Or will you go backward?"
				+ "Make a choice. Type r to go right, or b to go back to the previous room.");
		direction=keyboard.nextLine();
		while(!directionFound){
			if(direction.equals("r")){
				directionFound=true;
				room9();
			}
			else if(direction.equals("b")){
				directionFound=true;
				room3();
			}
			else{
				System.out.println("Command not recognized. Type r to go right, or b to turn back.");
				direction=keyboard.nextLine();
			}
		}
	}
	public void room5()
	{
		Scanner keyboard= new Scanner(System.in);
		String direction;
		Boolean directionFound=false;
		System.out.println("This path is darker and narrower…\nAs you approach the cluster of ramshackle houses, the smell of woodsmoke and something cooking grows stronger. ");
		System.out.println("A few of the houses’ windows are lit, and you feel many eyes upon you."); 
		System.out.println("You back into the shadows to assess your situation.");
		if(rooms[1][0].getMinion().isAlive())
		{
			System.out.println("Unfortunately, you are not alone.");
			core.fightEnemy(rooms[1][0].getMinion(),core.getPlayer());
		}
		System.out.println("The road extends in two directions. From the left, a voice taunts: \"Come here! Allow me to introduce myself!\""
				+ "\nyou may also proceed forward, if you choose. You can also turn back to the crossroads."
				+ "\nMake your choice. Type l to go to the left, f to move forward, and b to go back to the previous room.");
		direction=keyboard.nextLine();
		while(!directionFound){
			if(direction.equals("f")){
				directionFound=true;
				room6();
			}
			else if(direction.equals("l")){
				directionFound=true;
				room9();
			}
			else if(direction.equals("b")){
				directionFound=true;
				room1();
			}
			else{
				System.out.println("Command not recognized. Type f for forward, l for left, or b to go back.");
				direction=keyboard.nextLine();
			}
		}
	}
	public void room6()
	{
		Scanner keyboard= new Scanner(System.in);
		String direction;
		Boolean directionFound=false;
		System.out.println("You hear a creak, and see a door to the left starting to open.");
		System.out.println("An elderly-looking woman calls out to you. \"You look tired dear, come in for a moment and rest.\""
				+ "\n Will you trust her? Type y for yes or n for no.");
		direction=keyboard.nextLine();
		while(!directionFound){
			if(direction.equals("y")){
				directionFound=true;
				System.out.println("Despite what your mother told you about stranger danger, you accept.");
				room7();
			}
			else if(direction.equals("n")){
				directionFound=true;
				room5();
			}
			else{
				System.out.println("Command not recognized. Type y for yes or n for no.");
				direction=keyboard.nextLine();
			}
		}
	}
	public void room7()
	{
		String direction;
		Scanner keyboard= new Scanner(System.in);
		Boolean directionFound=false;
		System.out.println("Her house is small, but comfortable. \nOnce you are settled with a bowl of stew and a blanket, she tells you about the \"Creature\" that has terrorizing the city's citizens."
				+ "\nShe also hands you a homemade POTION. How thoughtful.");
		System.out.println("Sounds like the monster you've been looking for. You thank the woman and walk back out into the night.");
		System.out.println("The old woman has directed you to the path on the left." +
		"There is, however, also a fence straight ahead that you could probably jump over, if you wanted to."
		+ "\nWhat will you do? Type l to go left or f to go forward.");
		direction=keyboard.nextLine();
		while(!directionFound){
			if(direction.equals("f")){
				directionFound=true;
				room8();
			}
			else if(direction.equals("l")){
				directionFound=true;
				room9();
			}
			else{
				System.out.println("Command not recognized. Type f for forward, or l for left.");
				direction=keyboard.nextLine();
			}
		}
	}
	public void room8()
	{
		boolean solved=false;
		System.out.println("In one mighty and very heroic leap, you hop the fence and land majestically in the sad-looking field. ");
		System.out.println("You keep walking forward, and… oh. It’s a cliff. There’s nothing here.");
		System.out.println("You turn to go back and notice that the fence seems a lot higher somehow. Jumping doesn’t look like it will do the trick…");
		System.out.println("You look around for something that might help you escape. You find a POTION in the grass, but admittedly, there isn't much.");
		while(!solved){
			solved=fencePuzzle();
		}
		System.out.println("The only way to go is back.");
	}
	public void room9()
	{
		if(rooms[1][1].getBoss().isAlive()){
			System.out.println("As you enter the plaza, what initially appeared to be a huge pile of debris starts to quake.");
			System.out.println("It appears to be an enormous trash creature. \"Ah, welcome pesky traveller!\" it roars."
					+ "\n\"You have proven yourself to be most irksome in coming here. Once I defeat you, I will truly make this city great again!\""
					+ "\n\nYou prepare yourself for battle.");
			core.fightEnemy(rooms[1][1].getBoss(),core.getPlayer());
			rooms[1][1].getBoss().setAlive(false);
			System.out.println("After killing the creature you feel somehow stronger. You leave the city in search of the other horrible monsters.");
		}
		else
			System.out.println("You enter the plaza to find the creature already dead. Nice.");
	}
	public static boolean fencePuzzle(){
		Scanner keyboard= new Scanner(System.in);
		String direction,choice="*";
		boolean solved=false;
		System.out.println("Your search yields three items: a worn leather SATCHEL, a cracked wooden BUCKET, and a dashing feathered HAT.");
		System.out.println("You decide to try one. Type s,b,or h.");
		direction=keyboard.nextLine();
		while(!direction.equals("s")&&!direction.equals("b")&&!direction.equals("h")){
			System.out.println("Command not recognized. Type s, b, or h.");
			direction=keyboard.nextLine();
		}
		//Satchel
		if(direction.equals("s")){
			System.out.println("You open the satchel and look inside. It contains three small potions and a note.");
			System.out.println("You read the note:\n");
			System.out.println("I see that you have crossed my fence.\nI tell you now without pretense;\nThe potions you have chanced to find\nWill let you leave this field behind.");
			System.out.println("One will let you pass right through;\nOne is useless (harmless too);\nand one’s a simple sleeping brew.\n");
			System.out.println("One of three will do the trick,\nAll you have to do is pick,\nIf you are wrong, then try anew.\nSo take a chance- it’s up to you.");
			System.out.println("\nYou choose a potion. Type r for RED, g for GREEN, or p for PURPLE.");
			choice=keyboard.nextLine();
			while(!choice.equals("r")&&!choice.equals("g")&&!choice.equals("p")){
				System.out.println("Command not recognized. Type r, g, or p.");
				direction=keyboard.nextLine();
			}
			if(choice.equals("r")){
				System.out.println("You drink the RED potion and feel okay... maybe this is the right one.");
				System.out.println("You run at the fence, hoping for the best, and crash right into it. It's as solid as ever. Whoops.\n");
			}
			if(choice.equals("g")){
				System.out.println("You drink the GREEN potion...and fall asleep immediately.\nYou wake up four hours later, a little disoriented and still just as trapped.\n");
			}
			if(choice.equals("p")){
				System.out.println("You drink the PURPLE potion and feel a little dizzy. Gingerly, you step forward and pass through the fence.\n");
				solved=true;
			}
			
		}
		//Bucket
		if(direction.equals("b"))
			System.out.println("You drag the BUCKET over to the fence and try to stand on it. The fence is still too tall to jump over.\n");
		//Hat
		if(direction.equals("h"))
			System.out.println("You put the HAT on your head. Nothing happens.\nYou do look awfully nice though.\n");
		return solved;
	}
	//Get room to allow game engine to access minions and potions
	public Room getRoom(int r, int c)
	{
		return rooms[r][c];
	}
	
}