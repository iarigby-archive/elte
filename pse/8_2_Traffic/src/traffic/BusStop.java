package traffic;

import java.util.*;

public class BusStop {
	private String name;
	private List<Passenger> passengers = new ArrayList<Passenger>();
	
	public BusStop(String name) {
		this.name = name;
	}
	
	public List<Passenger> getPassengers() { return passengers; }
	
	public String getName() {return name;}
	
	public BusStop addPassenger(Passenger passenger) {
		passengers.add(passenger);
		return this;
	}
	
	public void acceptBus(Bus bus) {
		System.out.println("PASSENGERS WILL GET OF\n" + bus);
		List<Passenger> temp  = new ArrayList<Passenger>(bus.getPassengers());
		for (Passenger passenger : temp) {
			System.out.println(name + passenger.getDestination().getName());
			if (passenger.getDestination().equals(this)) {
				passenger.setGotOffAt(this);
				bus.getOff(passenger);
			}
		}
		
		System.out.println("PASSENGERS GOT OFF \n" + bus);


		
		System.out.println("PASSENGERS WILL GET ON \n" + this);
		System.out.println(passengers.size());
		for (int i = 0; i < this.passengers.size(); i++) {
			System.out.println(i);
			if (passengers.get(i).tryGetOn(bus, this)) {
				passengers.remove(passengers.get(i));
			}
			
			/*if (passengers.get(i).tryGetOn(bus, this)) {
				passengers.get(i).getOn(bus, this);
			}*/
		}
		System.out.println("PASSENGERS GOT ON\n"  +  bus + "\n REMAINING PASSENGERS" + this);
		
	} 
	
	public String toString() { return name + " " + passengers;}
}
