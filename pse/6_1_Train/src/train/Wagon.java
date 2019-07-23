package train;

public class Wagon {
	private int capacity;
	private String name;
	private int numberOfPassengers;
	
	public Wagon(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}
	
	public Wagon setNumberOfPassengers(int passengers) throws OverOccupiedException {
		if ( passengers > capacity) {
			throw new OverOccupiedException(this);
		} else {
			numberOfPassengers = passengers;
		}
		return this;
	}
	
	public int getNumberOfPassengers() { return  numberOfPassengers;}
	public String getName() {return name;}
	public int getCapacity() {return capacity;}
	
	@Override
	public String toString() {
		return name + " [" + numberOfPassengers + " of " + capacity + " seats are occupied]";
	}
}
