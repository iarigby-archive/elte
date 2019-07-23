package traffic;

public abstract class Passenger {
	private String name;
	private BusStop destination;
	private BusStop gotOffAt;
	
	public Passenger(String name, BusStop destionation) {
		this.name = name;
		this.destination = destionation;
	}
	
	public String getName() { return name;}
	
	public BusStop getDestination() {return destination;}
	
	public BusStop getGotOffAt() {return gotOffAt;}
	
	public void setGotOffAt(BusStop busStop) {gotOffAt = busStop;}
	
	public boolean tryGetOn(Bus bus, BusStop currentStop) {
		if (canGetOn(bus)) {
			getOn(bus, currentStop);
			return true;
		}
		return false;
	}
	
	public abstract boolean canGetOn(Bus bus);
	
	public abstract void getOn(Bus bus, BusStop currentStop);
	
	public String toString() {return name + " " + destination.getName();}
}
