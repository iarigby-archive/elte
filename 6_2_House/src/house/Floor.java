package house;

import java.util.*;

public class Floor {
	public int floorNumber;
	private Set<Flat> flats = new HashSet<Flat>();
	private ArrayList<Staircase> staircases = new ArrayList<Staircase>();
	
	public Floor(int n) {
		floorNumber = n;
	}
	
	//public List<String> validate() {
		
	//}
	
	public Set<Flat> getFlats() {
		return flats;
	}
	
	public List<Staircase> getStaircases() { return staircases; }
	
	public void addStaircase(Staircase staircase) {
		staircases.add(staircase);
	}
	
	public void addFlat(Flat flat) {flats.add(flat);}
	
}
