package train;

public class SleepingCar extends Wagon {
	public SleepingCar(int passengers) {
		super(" Sleeping Car", passengers);
	}
	
	@Override
	public String toString() {
		return this.getName() + " [" + getNumberOfPassengers() + " of " + getCapacity() + " beds are occupied]";
	}
}
