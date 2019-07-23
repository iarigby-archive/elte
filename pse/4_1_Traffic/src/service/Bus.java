package service;

public class Bus extends Vehicle {
	
	public Bus(String name, double c, double f) {
		super(name, c, f);
	}
	
	
	@Override
	public long getRefreshInterval() {
		return 2000;
	}
}
