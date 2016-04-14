package Areas;
import java.util.Scanner;

import General.Core;
//Woods mini=game for choose your own adventure.
public class Woods {
	
	private int hp = 100;
	private boolean boss = false;
	private Core core;
    
	public boolean monsterFight() {
		
		Scanner sc = new Scanner(System.in);
		String[] monster = {"a cyclops" , "a minataur", "a vampire", "the final boss!!!!"};
		int[] hpMon = {10, 150, 70, 500};
		String[] options = {"head", "torso", "right arm", "left arm"};
		int rand = (int) (Math.random()*2);
      if(boss == true)
         rand = 3;
		int currMon = hpMon[rand];
		System.out.println("You have ran into " + monster[rand] + "! It looks like it is going to attack you! It has " + currMon + " hp! Get ready to attack it back!");
		
		while(core.getPlayer().getHealth() > 0 && currMon != 0) {
			String compAttack, compDefend;
			String attack = "";
			String defend = "";
			boolean exists = false;
			while(exists == false) {
				System.out.println("Choose where to attack! (Type head, torso, right arm, or left arm!)");
				attack = sc.nextLine();
				for(int i = 0; i < options.length-1; i++) {
					if(attack.equals(options[i]))
						exists = true;
				}
				if(exists == false)
					System.out.println("Please choose a valid position to attack!");
			}
			exists = false;
			while(exists == false) {
				System.out.println("Choose where to defend! (Type head, torso, right arm, or left arm!)");
				defend = sc.nextLine();
				for(int i = 0; i < options.length-1; i++) {
					if(defend.equals(options[i]))
						exists = true;
				}
				if(exists == false)
					System.out.println("Please choose a valid location to defend!");
			}
			compAttack = options[(int)(Math.random()*3)];
			compDefend = options[(int)(Math.random()*3)];
			if(compAttack.equals(defend))
				System.out.println("The monster missed!");
			else {
				core.getPlayer().setHealth(core.getPlayer().getHealth() - 1);
				System.out.println("The monster has hit you in the " + compAttack + "! You have " + hp + " left!");
			}
			if(compDefend.equals(attack))
				System.out.println("You missed!");
			else {
				currMon-=core.getPlayer().getAttack();
				System.out.println("You have hit the monster in the " + attack + "! It has " + currMon + " left!");
			}
		}
		if(currMon == 0)
			return true;
		return false;
	}
	public int pathFinder(String p) {
		//Path solutions and possible paths.
		String[] paths = {"lrlllrl", "rlrlrllrr", "llr", "lllr", "llll", "lrrl", "lrrrl", "lrrrr", "lrlr", "lrllr", "lrllll", "lrlllrr", "lrlllrl", "rrrr", "rrl", "rrrl", "rll", "rlrr", "rlrll", "rlrlrr", "rlrlrlr", "rlrlrlll", "rlrlrllrl"};
		//"end" array is for determining what has been found, "paths" and "end" correspond. 0 = spellbook 1 = main monster 2 = dead-end 3 = random bonus(?) 4 = mini-monster
		int[] end = {0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
		//Loop to check to see if a destination, or dead-end, has been reached.
		for(int i = 0; i < paths.length-1; i++) {
			if (p.equals(paths[i]))
				return end[i];
		}
		return -1;
	}
	//Method to go back to the previous fork in the road.
	public String goBack(String p) {
		String backOne = "";
		//Check for that there is a for-loop to run through.
		if (p.equals("") || p.length() == 1)
			return backOne;
		else {
			//Creating a string minus the last element.
			for(int i = 0; i < p.length()-1; i++)
				backOne += p.charAt(i);
		}
		return backOne;
	}
	//Main method for the mini-game!
	public Woods(Core core) {
		this.core = core;
		Scanner sc = new Scanner(System.in);
		String path = "";
		boolean lost = true;
		String temp = "";
		boolean spellbook = false;
		boolean start = true;
		while(lost) {
		//Text to show up if you're at the entrance.
		if(start == true) {
			System.out.println("Welcome to the woods!\nArriving at the woods, you find two paths before you. On either side, there is a tree with some scrawling on it."
					+ " Would you like to read what is on one of the tree? Type y/n:");
			temp = sc.nextLine();
			//Choosing yes for riddles.
			if(temp.equals("y")) {
				System.out.println("Would you like to read the one of the left or right? Type r/l:");
				temp = sc.nextLine();
				//Riddle for spellbook.
				if(temp.equals("r")) {
					System.out.println("The ancient dragon left his home to right a world of wrong. But after he left his first destination, "
							+ " he found that he could not do it without a sorceror to help him.\nRealizing this fact, he left his home once again and left"
							+ " the earth to create a spellbook of great power for a sorceror to use.\nLegend says that this spell book is right in this forest,"
							+ " if any man is wise enough to solve the riddle left behind.");
				}
				//Riddle for finding the monster to beat.
				if(temp.equals("l")) {
					System.out.println("The monster you seek is anything but right, but he left destruction with a key."
							+ "\nTo stop true evil in the evilest being, you must right him you see."
							+ "\nBut only solving this riddle left, can you tell which is the right path in mind."
							+ "\nBut be wary passerby for many obstacles were left, left for you to find."
							+ "\nThis forest has more than one right way to get lost, and you don't know how much they cost."
							+ "\nSo one last warning from me to you, for what you see is right is true.");
				}
			}		
			//Choosing no riddles.
			else if(temp.equals("n")) {
				System.out.println("You look to the paths before you.");
			}
			start = false;
		}
		//While you're not at the start...
		else {
         if((int) (Math.random()*2) == 0) {
					if(monsterFight() == false) {
						System.out.println("You have lost! You are brought back to the beginning!");
						path = "";
					}
            }
			System.out.println("Choose which path to take now! Type l/r to choose or b to go back to last crossroad:");
			temp = sc.nextLine();
			//Option to go back to previous fork in the road.
			if(temp.equals("b")) {
				path = goBack(path);
				if (path.equals(""))
					start = true;
			}
			//Choosing a path.
			else {
				path += temp;
				//Finding the spellbook riddle.
				if(pathFinder(path) == 0) {
					System.out.println("You find a sad old man sitting on the tree stump. He is holding a rusty old book in his hands. He turns to look at you as you approach him and asks:" +
							"\n\"Are you here to take my book? Enter y/n.\"");
					temp = sc.nextLine();
					//Choosing no.
					if(temp.equals("n"))
						System.out.println("The wizard looks at you angrily and waves a wooden wand at you." + "\n\"Then back to the start you go!\"");
					//Choosing yes.
					if(temp.equals("y")) {
						int chances = 3;
						System.out.println("The wizards looks at you up and down. Then combs his beard while looking at his book."
								+ "\n\"Only the wise shall have the right to have my spellbook. And only the wise would know exactly the path that was taken. "
								+ "\nTell me young one, what was the path?\"");
						temp = sc.nextLine();
						//Loop for guessing while you still have a chance.
						while (chances != 0){
							System.out.println("(Type a path using r and l, you have " + chances + " chances!)");
							//Correct answer.
							if(temp.equals("lrlllrl")) {
								System.out.println("The wizard smiles happily at you and hands you his spellbook." +
										"\"Take care of it young one.\" He says happily. \"Now where you want to go is a very different place from here, so I will send you back to" +
										" the start. Read what I wrote on the tree if you're not sure where to go! I'm sure you will see the meaning behind my words!");
								spellbook = true;
							}
							//When incorrect.
							else {
								System.out.println("The wizards shakes his head somberly.");
								chances--;
								if(chances == 0)
									System.out.println("The wizards stands up angrily and waves a wooden wand at you.");
							}
						}	
					}
					path = "";
				}
				//The monster goal of the forest to leave the forest.
				else if(pathFinder(path) == 1) {
					boss = true;
               if(monsterFight() == true) {
					   lost = false;
					   System.out.println("Congratulations, you beat the game!");
					   System.exit(0);
               }
               else{
                  path = "";
                  boss = false;
               }
				}
				//Deadends.
				else if(pathFinder(path) == 2) {
					while(!temp.equals("b")) {
						System.out.println("You have reached a deadend! Press b to go back!");
						temp = sc.nextLine();
						if(temp.equals("b")){
							path = goBack(path);
							
						}
					}
					temp = "";
				}
			}
		}
		}
      //Out of main loop.
	}
	
}
