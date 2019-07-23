package service;

public class Car extends Vehicle {

	public Car(String name, double c, double f) {
		super(name, c, f);
	}
	
	@Override
	public long getRefreshInterval() {
		return 1000;
	}
}
