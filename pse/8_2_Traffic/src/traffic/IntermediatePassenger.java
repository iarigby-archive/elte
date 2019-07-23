package traffic;

public class IntermediatePassenger extends Passenger{

	public IntermediatePassenger(String name, BusStop destination) {
		super(name, destination);
	}
	
	public boolean canGetOn(Bus bus) {
		return true;
	}
	
	public void getOn(Bus bus, BusStop currentStop) {
        bus.getOn(this);
    }
}
