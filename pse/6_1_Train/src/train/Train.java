package train;

import java.util.ArrayList;

public class Train {
	
	private String name;
	private Locomotive locomotive;
	private ArrayList<Wagon> wagons = new ArrayList<Wagon>();
	
	public Train(Locomotive locomotive, String name) {
		this.name = name;
		this.locomotive = locomotive;
	}
	
	public void addWagon(Wagon w) {
		wagons.add(w);
	}
	

	public int getFreeCapacity() {
		int sum = 0;
		for (Wagon wagon : wagons) {
			sum += wagon.getCapacity() - wagon.getNumberOfPassengers();
		}
		return sum;
	}
	
	public int getNumOfFreeSeats() {
		int sum = 0;
		for (Wagon wagon : wagons) {
			if (!wagon.getName().equals(" Sleeping Car")) {
				sum += wagon.getCapacity() - wagon.getNumberOfPassengers();
			}
		}
		return sum;
	}
	
	public int getNumOfFreeBeds() {
		return getFreeCapacity() - getNumOfFreeSeats();
	}
	
	public String toString() {
		String result = "Train " + name + " has a " + locomotive + " locomotive and the following cars: ";
		for (Wagon wagon: wagons) {
			result += wagon;
		}
		return result;
	}
	
	
	
}
