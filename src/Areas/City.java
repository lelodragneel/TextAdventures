package Areas;

//Here's the basic outline for my game. It's still missing methods for changing character health, boss battles, and item finding.
import java.util.Scanner;

import Enemies.Boss;
import Enemies.Minion;
import General.Item;
import General.Room;

public class City extends Area {

	/*
	 * initialize variables
	 */
	private Scanner keyboard;
	private Room[][] rooms;
	private General.Character player;
	
	
	// constructor
	public City(General.Character player) {
		
		this.player = player;
		keyboard = new Scanner(System.in);

		rooms[0][0] = new Room(null, null, null, false);
		rooms[0][1] = new Room(null, null, null, false);
		rooms[0][2] = new Room(null, null, null, false);
		rooms[1][0] = new Room(null, null, null, false);
		rooms[1][1] = new Room(new Boss(1, 1, "filler"), null, null, false);
		rooms[1][2] = new Room(null, null, null, false);
		rooms[2][0] = new Room(null, null, null, false);
		rooms[2][1] = new Room(null, null, null, false);
		rooms[2][2] = new Room(null, null, null, false);
		
	}
	
	public void crossroads() {
		
		// Necessary variables/objects added
		String direction;
		int roomNum = 0;
		keyboard = new Scanner(System.in);
		
		System.out
				.println("\nLooking FORWARD, the city's wide main street stretches out before you, bathed in shadow from the looming buildings on either side.");
		System.out
				.println("To your LEFT, a narrower street winds off through a collection of smaller buildings. Lights can be seen in the distance.");
		System.out
				.println("To your RIGHT, a short fence separates the path from a scruffy-looking field. You could jump over it, if you wanted to.");
		// User is prompted to choose a direction
		System.out
				.println("\nWhich way will you go? Type f for forward, l for left, or r for right.");
		direction = keyboard.nextLine();
		
		while (roomNum == 0) {
			if (direction.equals("f"))
				roomNum = 2;
			else if (direction.equals("l"))
				roomNum = 3;
			else if (direction.equals("r"))
				roomNum = 5;
			else {
				System.out
						.println("Command not recognized. Type f for forward, l for left, or r for right.");
				direction = keyboard.nextLine();
			}
		}
		choosePath(roomNum);
	}

	public void room2() {
		
		keyboard = new Scanner(System.in);
		String direction = "*";
		System.out
				.println("You proceed straight ahead. The buildings seem taller from this angle, but also a lot more… run down?");
		System.out
				.println("Something seems to have driven the city's inhabitants away…");
		System.out
				.println("As you stare thoughtfully upward, something grabs you from behind…");
		// User is forced to battle a monster. If they die, they must return to
		// the crossroads.
		monsterBattle("trash creature");
		
		System.out
				.println("You sit down on a bit of rubble to recover. Wait... what's that over there?");
		System.out.println("Investigate? Type y or n.");
		direction = keyboard.nextLine();
		
		while (!direction.equals("y") && !direction.equals("n")) {
			System.out.println("Command not recognized. Type y or n.");
			direction = keyboard.nextLine();
		}
		
		if (direction.equals("y")) {
			System.out.println("Another creature leaps out from the shadows.");
			// User battles a monster. If they die, they must return to the
			// crossroads.
			monsterBattle("sneaky trash creature");
			// After winning, user acquires shield
			System.out
					.println("Triumphantly, you reach into the pile of debris and pull out a SHIELD.");
			// User acquires shield item. If they are a warrior, their stats
			// rise accordingly and set item to "true".
			// Check whether the boss has been defeated. If so, congratulatory
			// message. End level.
			// If not, the user must now choose a different path to walk.
			System.out
					.println("There doesn't seem to be anything more to explore down this path.\nYou make your way back to the crossroads.");
			choosePath(0);
		}
		
		if (direction.equals("n")) {
			System.out.println("You make your way back to the crossroads.");
			choosePath(0);
		}
	}

	public void room3() {
		
		keyboard = new Scanner(System.in);
		String direction = "*";
		
		System.out
				.println("This path is darker and narrower…\nAs you approach the cluster of ramshackle houses, the smell of woodsmoke and something cooking grows stronger. ");
		System.out
				.println("A few of the houses' windows are lit, and you feel many eyes upon you.");
		System.out
				.println("You hear a creak, and see a door starting to open.You have just enough time to retreat, if you choose to.");
		System.out
				.println("Will you retreat? Or will you move forward? Type r or f.");
		direction = keyboard.nextLine();
		
		while (!direction.equals("r") && !direction.equals("f")) {
			System.out.println("Command not recognized. Type r or f.");
			direction = keyboard.nextLine();
		}
		
		if (direction.equals("r")) {
			System.out
					.println("You RETREAT to the shadows and wait until whoever it is goes back inside.");
			System.out.println("Unfortunately, you're not alone.");
			// User battles a monster
			monsterBattle("shadow creature");
			System.out
					.println("He can't have roamed very far… scouting ahead may lead you to his source.");
			System.out
					.println("Type s to scout ahead, or c to return to the CROSSROADS.");
			direction = keyboard.nextLine();
			while (!direction.equals("s") && !direction.equals("c")) {
				System.out.println("Command not recognized. Type s or c.");
				direction = keyboard.nextLine();
			}
			if (direction.equals("s")) {
				// User is sent to the boss room
				choosePath(4);
			}
			if (direction.equals("c")) {
				// User is sent back to the crossroads
				choosePath(0);
			}
		}
		
		if (direction.equals("f")) {
			System.out
					.println("An elderly-looking woman calls out to you. \"You look tired dear, come in for a moment and rest.\" ");
			System.out
					.println("Despite what your mother told you about stranger danger, you accept.");
			System.out
					.println("Her house is small, but comfortable. \nOnce you are settled with a bowl of stew and a blanket, she tells you about the \"Creature\" that has terrorizing the city's citizens. ");
			System.out
					.println("Sounds like the monster you've been looking for. You thank the woman and walk back out into the night.");
			System.out
					.println("Will you face the monster? Or will you return to the CROSSROADS? Type f or c.");
			direction = keyboard.nextLine();
			
			while (!direction.equals("f") && !direction.equals("c")) {
				System.out.println("Command not recognized. Type f or c.");
				direction = keyboard.nextLine();
			}
			
			if (direction.equals("f")) {
				// User is sent to the boss room
				choosePath(4);
			}
			
			if (direction.equals("c")) {
				// User is sent back to the crossroads
				choosePath(0);
			}
		}

	}

	public void bossRoom() {
		
		System.out.println("BOSS BATTLE");
		// Check whether boss has already been defeated. If not,
		monsterBattle("final boss");
		// Check whether the item has also been found if boss is defeated. If
		// so, congratulatory message. End level.
		// If not, just update bossDefeated to true and return to the
		// crossroads.
		crossroads();
	}

	public void room5() {
		boolean solved = false;
		System.out
				.println("In one mighty and very heroic leap, you hop the fence and land majestically in the sad-looking field. ");
		System.out
				.println("You keep walking forward, and… oh. It's a cliff. There's nothing here.");
		System.out
				.println("You turn to go back and notice that the fence seems a lot higher somehow. Jumping doesn't look like it will do the trick…");
		System.out
				.println("You look around for something that might help you escape. Admittedly, there isn't much.");
		while (!solved) {
			solved = fencePuzzle();
		}
		System.out
				.println("Finally, you manage to escape back to the crossroads.");
		crossroads();
		
	}

	public void monsterBattle(String name) {
		
		boolean userLives = true;
		int diceRoll;
		System.out.println();
		System.out.println(name + " attacks.");
		// Just filler until we work out how we're actually doing battles.
		diceRoll = (int) (Math.random() * 3 + 1);
		
		if (diceRoll == 1 || diceRoll == 2)
			System.out.println("You defeat the " + name + ".\n");
		else {
			System.out
					.println("You die.\nYou wake up again, back in the crossroads.");
			crossroads();
		}
		// If the user dies, display message and send them back to the
		// crossroads.
	}

	public boolean fencePuzzle() {
		
		keyboard = new Scanner(System.in);
		String direction, choice = "*";
		boolean solved = false;
		System.out
				.println("Your search yields three items: a worn leather SATCHEL, a cracked wooden BUCKET, and a dashing feathered HAT.");
		System.out.println("You decide to try one. Type s,b,or h.");
		direction = keyboard.nextLine();
		
		while (!direction.equals("s") && !direction.equals("b")
				&& !direction.equals("h")) {
			System.out.println("Command not recognized. Type s, b, or h.");
			direction = keyboard.nextLine();
		}
		
		// Satchel
		if (direction.equals("s")) {
			System.out
					.println("You open the satchel and look inside. It contains three small potions and a note.");
			System.out.println("You read the note:\n");
			System.out
					.println("I see that you have crossed my fence.\nI tell you now without pretense;\nThe potions you have chanced to find\nWill let you leave this field behind.");
			System.out
					.println("One will let you pass right through;\nOne is useless (harmless too);\nand one's a simple sleeping brew.\n");
			System.out
					.println("One of three will do the trick,\nAll you have to do is pick,\nIf you are wrong, then try anew.\nSo take a chance- it's up to you.");
			System.out
					.println("\nYou choose a potion. Type r for RED, g for GREEN, or p for PURPLE.");
			choice = keyboard.nextLine();
			while (!choice.equals("r") && !choice.equals("g")
					&& !choice.equals("p")) {
				System.out.println("Command not recognized. Type r, g, or p.");
				direction = keyboard.nextLine();
			}
			if (choice.equals("r")) {
				System.out
						.println("You drink the RED potion and feel okay... maybe this is the right one.");
				System.out
						.println("You run at the fence, hoping for the best, and crash right into it. It's as solid as ever. Whoops.\n");
			}
			if (choice.equals("g")) {
				System.out
						.println("You drink the GREEN potion...and fall asleep immediately.\nYou wake up four hours later, a little disoriented and still just as trapped.\n");
			}
			if (choice.equals("p")) {
				System.out
						.println("You drink the PURPLE potion and feel a little dizzy. Gingerly, you step forward and pass through the fence.\n");
				solved = true;
			}

		}
		// Bucket
		if (direction.equals("b"))
			System.out
					.println("You drag the BUCKET over to the fence and try to stand on it. The fence is still too tall to jump over.\n");
		// Hat
		if (direction.equals("h"))
			System.out
					.println("You put the HAT on your head. Nothing happens.\nYou do look awfully nice though.\n");
		return solved;
	}

	public void choosePath(int r) {
		// crossroads
		if (r == 0)
			crossroads();
		// forward
		if (r == 2)
			room2();
		// left
		if (r == 3)
			room3();
		// boss
		if (r == 4)
			bossRoom();
		// right
		if (r == 5)
			room5();

	}
	
	//Get room to allow game engine to access minions and potions
	public Room getRoom(int r, int c)
	{
		return room[r][c];
	}
}