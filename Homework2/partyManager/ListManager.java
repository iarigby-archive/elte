package partyManager;

import main.LionKingParty;

import java.util.HashMap;
import java.util.Scanner;

public class ListManager extends Entrance {
		
	public void addGuest(String name, Specie specie, Song song) {
		Animal animal;
		switch(specie.getType()) {
			case LAND:
				int numberOfPaws = LionKingParty.getInt("Enter Number of Paws");
				animal = new NormieAnimal(name, specie, numberOfPaws);
				break;
			case WATER:
				int n = LionKingParty.getInt("How does the animal arrive? Enter 1 for river and 2 for sea", "", 1, 2);
				String comesFrom = "river";
				if (n == 2)
					comesFrom = "sea";
				animal = new SwimmingAnimal(name, specie, comesFrom);
				break;
			case AIR:
				int wingExtension = LionKingParty.getInt("How long are the animal's wings? (in cm)");
				animal = new FlyingAnimal(name, specie, wingExtension);
				break;
			//I kept getting error  variable animal might not have been initialized for line 34 and this is why I put next lines
			default:
				animal = null;
		}
		getGuestList().put(name, animal);
		getPlayList().add(song);
	}

	public boolean removeGuest(String name) {
		if(getGuestList().remove(name) != null)
			return true;
		return false;
	}

}
