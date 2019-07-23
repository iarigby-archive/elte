package main;

import partyManager.*;

import java.util.Scanner;
import java.util.HashMap;

public class LionKingParty {
	
	static Scanner input = new Scanner(System.in);
	static SongManager zazu = new SongManager();
	static ListChecker rafiki = new ListChecker();
	static ListManager mufasa = new ListManager();

	public static void main(String[] args) {

		String choice;

		do {
			System.out.println("\n\n\t enter number for your choice" + menu);
			choice = input.nextLine();
			Choose(choice);
		} while (!choice.equals("0"));

	}


	public static void Choose(String choice) {

		switch(choice) {
			case "1":
				registerGuest();
				break;
			case "2":
				removeGuest();
				break;
			case "3":
				sortSong();
				break;
			case "4":
				listSongs();
				break;
			case "5":
				checkList();
				break;
			case "6":
				listNeedsByName();
				break;
			case "7":
				ListNeedsBySpecies();
				break;
		}

	}

	public static void registerGuest() {
		String name;
		do {
			name = getInput("Enter Guest's name");
			if (rafiki.isOnList(name)) 
				System.out.println("guest with that name is already on the list, please enter a unique name");
		} while (rafiki.isOnList(name));
		int specieIndex = getInt("Please chooce from species:\n" + Specie.getList(), "from list", 1, Specie.values().length);
		String songName = getInput("Enter chosen song's title");
		String songArtist = getInput("Enter artist");
		mufasa.addGuest(name, Specie.values()[specieIndex-1], new Song(songName, songArtist));
	}

	public static void removeGuest() {
		String name = getInput("Enter name of the guest you would like to remove");
		if (mufasa.removeGuest(name)) 
			System.out.println("Guest has been removed.");
		else
			System.out.println("Guest with that name is not on the list");
	}

	public static void sortSong() {
		System.out.println("Now Playing: " + zazu.playSong());
	}

	public static void listSongs() {
		System.out.println("Played Songs are:\n" + zazu.listPlayedSongs());
	}

	public static void checkList() {
		String name = getInput("Enter Guest's name");
		if (rafiki.isOnList(name))
			System.out.println(name + " is allowed");		
		else
			System.out.println(name + " is not allowed");
	}

	public static void listNeedsByName() {
		System.out.println("Needs for guests are: \n" + rafiki.listNeeds());
	}

	public static void ListNeedsBySpecies() {
		System.out.println("Needs for Species in guestList are: \n" + rafiki.needsBySpecie());
	}

	public static String getInput(String prompt) {
		System.out.print("\t" + prompt + ": ");
		String in = input.nextLine().toLowerCase();
		return in;
	}

	public static int getInt(String prompt, String exceptionHandler, int min, int max) {
		int result = min-1;
		do {
			try {
				result = Integer.parseInt(getInput(prompt));
			} catch (Exception e) {
				System.out.println("you need to enter an integer value " + exceptionHandler);
			}
		} while (result < min || result > max);
		return result;
	}

	public static int getInt(String prompt) {
		Integer result = null;
		while (result == null) {
			try {
				result = Integer.parseInt(getInput(prompt));
			} catch (Exception e) {
				System.out.println("you need to enter an integer value");
			}
		}
		return result;
	}

	static String menu = " \n 1. Register guest \n 2. Remove a guest \n 3. Pick a song \n 4. List played songs\n 5. Check if an animal is on the Guest list\n 6. List animal needs by animal name\n 7. List animal needs by specie name\n 9. exit\n";
	

}