package house;

import java.util.*;

public class House {
	private List<Floor> floors = new ArrayList<Floor>();
	private Set<Staircase> staircases = new HashSet<Staircase>();	

	public House (Staircase staircase) {
		staircases.add(staircase);
	}
	
	public void addFloor(Floor floor) {
		floors.add(floor);
	}
	
	public void addStaircase(Staircase staircase ) {
		staircases.add(staircase);
	}
	
	public Set<Staircase> getStaircases() {
		return staircases;
	}
	
	public List<Floor> getFloors() {
		return floors;
	}
	
}
