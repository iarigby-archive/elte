package application;

public class Counter {

	private int counter;
	
	public Counter() {
		counter = 1;
	}
	
	public void reset() {
		counter = 1;
	}
	
	public void increase() {
		counter++;
	}
	
	@Override
	public String toString() {
		return Integer.toString(counter);
	}
}
