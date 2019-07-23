package traffic;

public class BeginnerPassenger extends Passenger {
	
	public BeginnerPassenger(String name, BusStop destination) {
		super(name, destination);
	}
	
	public boolean canGetOn(Bus bus) {
		return !bus.isFull();
	}
	
	public void getOn(Bus bus, BusStop currentStop) {
        bus.getOn(this);
    }
	
}
