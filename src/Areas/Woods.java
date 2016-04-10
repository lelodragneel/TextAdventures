package Areas;

import java.util.Scanner;

import General.Boss;
import General.Item;
import General.Minion;
import General.Room;

public class Woods extends Area{

	/*
	 * initialize variables
	 */
	
	public Woods(General.Character player) {
		
		// TODO change boss/minion values from 0 to something realistic
		// create a 3X3 matrix as the map for this area
		// reminder: room[row][col]
		room[0][0] = new Room(null, null, null, false);
		room[0][1] = new Room(null, new Minion(0, 0, "Angry Sapling"), new Item(0, 0, "[Warrior] Long Sword"), false);
		room[0][2] = new Room(null, null, null, true);
		room[1][0] = new Room(null, new Minion(0, 0, "Angry Sapling"), new Item(0, 0, "[Warrior] Chest Plate"), false);
		room[1][1] = new Room(new Boss(0, 0, "Angry Tree Spirit"), null, null, false);
		room[1][2] = new Room(null, null, null, true);
		room[2][0] = new Room(null, null, null, true);
		room[2][1] = new Room(null, null, new Item(0, 0, "Ring (Damage Buff)"), false);
		room[2][2] = new Room(null, new Minion(0, 0, "Angry Sapling"), new Item(0, 0, "[Thief] Dagger"), false);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	//Main method for the mini-game!
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String path = "";
//		boolean lost = true;
//		String temp = "";
//		boolean spellbook = false;
//		boolean start = true;
//		while(lost) {
//			System.out.println("The path is " + path);
//		//Text to show up if you're at the entrance.
//		if(start == true) {
//			System.out.println("Welcome to the woods!\nArriving at the woods, you find two paths before you. On either side, there is a tree with some scrawling on it."
//					+ " Would you like to read what is on one of the tree? Type y/n:");
//			temp = sc.nextLine();
//			//Choosing yes for riddles.
//			if(temp.equals("y")) {
//				System.out.println("Would you like to read the one of the left or right? Type r/l:");
//				temp = sc.nextLine();
//				//Riddle for spellbook.
//				if(temp.equals("r")) {
//					System.out.println("The ancient dragon left his home to right a world of wrong. But after he left his first destination, "
//							+ " he found that he could not do it without a sorceror to help him.\nRealizing this fact, he left his home once again and left"
//							+ " the earth to create a spellbook of great power for a sorceror to use.\nLegend says that this spell book is right in this forest,"
//							+ " if any man is wise enough to solve the riddle left behind.");
//				}
//				//Riddle for finding the monster to beat.
//				if(temp.equals("l")) {
//					System.out.println("The monster you seek is anything but right, but he left destruction with a key."
//							+ "\nTo stop true evil in the evilest being, you must right him you see."
//							+ "\nBut only solving this riddle left, can you tell which is the right path in mind."
//							+ "\nBut be wary passerby for many obstacles were left, left for you to find."
//							+ "\nThis forest has more than one right way to get lost, and you don't know how much they cost."
//							+ "\nSo one last warning from me to you, for what you see is right is true.");
//				}
//			}		
//			//Choosing no riddles.
//			else if(temp.equals("n")) {
//				System.out.println("You look to the paths before you.");
//			}
//			start = false;
//		}
//		//While you're not at the start...
//		else {
//			System.out.println("Choose which path to take now! Type l/r to choose or b to go back to last crossroad:");
//			temp = sc.nextLine();
//			//Option to go back to previous fork in the road.
//			if(temp.equals("b")) {
//				path = goBack(path);
//				if (path.equals(""))
//					start = true;
//			}
//			//Choosing a path.
//			else {
//				path += temp;
//				//Finding the spellbook riddle.
//				if(pathFinder(path) == 0) {
//					System.out.println("You find a sad old man sitting on the tree stump. He is holding a rusty old book in his hands. He turns to look at you as you approach him and asks:" +
//							"\n\"Are you here to take my book? Enter y/n.\"");
//					temp = sc.nextLine();
//					//Choosing no.
//					if(temp.equals("n"))
//						System.out.println("The wizard looks at you angrily and waves a wooden wand at you." + "\n\"Then back to the start you go!\"");
//					//Choosing yes.
//					if(temp.equals("y")) {
//						int chances = 3;
//						System.out.println("The wizards looks at you up and down. Then combs his beard while looking at his book."
//								+ "\n\"Only the wise shall have the right to have my spellbook. And only the wise would know exactly the path that was taken. "
//								+ "\nTell me young one, what was the path?\"");
//						temp = sc.nextLine();
//						//Loop for guessing while you still have a chance.
//						while (chances != 0){
//							System.out.println("(Type a path using r and l, you have " + chances + " chances!)");
//							//Correct answer.
//							if(temp.equals("lrlllrl")) {
//								System.out.println("The wizard smiles happily at you and hands you his spellbook." +
//										"\"Take care of it young one.\" He says happily. \"Now where you want to go is a very different place from here, so I will send you back to" +
//										" the start. Read what I wrote on the tree if you're not sure where to go! I'm sure you will see the meaning behind my words!");
//								spellbook = true;
//							}
//							//When incorrect.
//							else {
//								System.out.println("The wizards shakes his head somberly.");
//								chances--;
//								if(chances == 0)
//									System.out.println("The wizards stands up angrily and waves a wooden wand at you.");
//							}
//						}	
//					}
//					path = "";
//				}
//				//The monster goal of the forest to leave the forest.
//				else if(pathFinder(path) == 1) {
//					//big bad monster
//					lost = false;
//					System.out.println("Congratulations, you escaped the woods!");
//				}
//				//Deadends.
//				else if(pathFinder(path) == 2) {
//					while(!temp.equals("b")) {
//						System.out.println("You have reached a deadend! Press b to go back!");
//						temp = sc.nextLine();
//						if(temp.equals("b")){
//							path = goBack(path);
//							
//						}
//					}
//					temp = "";
//				}
//				else if(pathFinder(path) == 3) {
//					//random health
//					while(!temp.equals("b")) {
//						System.out.println("You have reached a deadend! Press b to go back!");
//						temp = sc.nextLine();
//						if(temp.equals("b")){
//							path = goBack(path);
//							
//						}
//					}
//				}
//				else if(pathFinder(path) == 4) {
//					//random monster
//					while(!temp.equals("b")) {
//						System.out.println("You have reached a deadend! Press b to go back!");
//						temp = sc.nextLine();
//						if(temp.equals("b")){
//							path = goBack(path);
//							
//						}
//					}
//				}
//			}
//		}
//		}
//	}
	
}
