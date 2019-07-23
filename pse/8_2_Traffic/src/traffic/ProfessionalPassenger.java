package traffic;

import java.util.Random;

public class ProfessionalPassenger extends Passenger{
	private Random md;
	
	public ProfessionalPassenger(String name, BusStop destination, Random md) {
		super(name, destination);
		this.md = md;
	}
	
	public boolean canGetOn(Bus bus) {
		return true;
	}
	
	public void getOn(Bus bus, BusStop currentStop) {
		
		Passenger kickoff;
		while (bus.isFull()) {
			kickoff = bus.getPassengers().get(md.nextInt(bus.getPassengers().size()));
			bus.getOff(kickoff);
			kickoff.setGotOffAt(currentStop);
		}
		/*
		 * 
		 * 
		 * kickoff = (bus.getPassengers().get(md.nextInt(bus.getPassengers().size())));
		currentStop.addPassenger(kickoff);
		bus.getOff(kickoff);
	*/
		bus.getOn(this);
		
	}
}
