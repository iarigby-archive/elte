package partyManager;

import java.util.HashMap;
import java.util.HashSet;

public class ListChecker extends Entrance{
	
	public boolean isOnList	(String name) {
		if (getGuestList().containsKey(name))
			return true;
		return false;
	}

	public String checkNeed(String name) {
		if (getGuestList().containsKey(name))
			return name + " needs " + getGuestList().get(name).getSpecie().getNeed();
		return "such animal is not on the list";
	}

	public String listNeeds() {
		String result = "";
		for (Animal animal : getGuestList().values())
			result += animal.getName() + " needs " + animal.getSpecie().getNeed() + "\n";
		return result;
	}

	public String needsBySpecie() {
		String result = " ";
		HashSet<Specie> species= new HashSet<Specie>();
		for (Animal animal : getGuestList().values()) 
			species.add(animal.getSpecie());
		for (Specie specie : species) 
			result += specie.name() + " needs " + specie.getNeed() + "\n";
		return result;
	}
}