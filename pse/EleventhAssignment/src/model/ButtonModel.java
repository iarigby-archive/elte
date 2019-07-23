package model;

public class ButtonModel {

	private final int REDCLICK = 5;
	private int counter;
	
	public ButtonModel() {
		counter = 0;
	}
	
	public boolean changeColor() {
		if (counter > 1) {
			return counter % REDCLICK == 0;
		}
		return false;
	}
	
	public void increaseCounter() { counter++; }
	
	public int getCounter() { return counter; }
	
	@Override
	public String toString() {return Integer.toString(counter);}
	
}
