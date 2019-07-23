package partyManager;

import java.util.ArrayList;
import java.util.HashMap;

public class Entrance {
	private static HashMap<String, Animal> guestList = new HashMap<String, Animal>();
	private static ArrayList<Song> playList = new ArrayList<Song>();

	public ArrayList<Song> getPlayList() { 
		return playList;
	}

	public HashMap<String, Animal> getGuestList() {
		return guestList;
	}

}