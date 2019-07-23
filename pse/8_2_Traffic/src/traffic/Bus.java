package traffic;

import java.util.*;

public class Bus {
	private int capacity;
	private List<Passenger> passengers = new ArrayList<Passenger>();
	
	public Bus(int capacity) {
		this.capacity = capacity;
	}
	
	public void getOn(Passenger passenger) { passengers.add(passenger);}
	
	public void getOff(Passenger passenger) {passengers.remove(passenger);}
	
	public boolean isFull() { return passengers.size() == capacity; }
	
	public List<Passenger> getPassengers() { return passengers; }
	
	
	public String toString() {
		String result = "BUS with capacity " + capacity + ", passengers: \n";
		
		for (Passenger passenger : passengers) {
			result+= passenger + ", ";
		}
		
		return result;
	}
}
