package house;

import java.util.*;

public class Staircase {
	
	public int staircaseNumber;
	private Set<Floor> floors = new HashSet<Floor>();
	
	public Staircase(int n) {
		staircaseNumber = n;
	}
	
	public void validate() throws TooFewStaircaseFloors{
		if (staircaseNumber < 5) {
			throw new TooFewStaircaseFloors(this);
		}
	}

	public void addFloor(Floor floor) {
		floors.add(floor);
	}
	
	public Set<Floor> getFloors() {return floors;}
}
