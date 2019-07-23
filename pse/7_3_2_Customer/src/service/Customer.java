package service;

import java.util.Random;

public abstract class Customer {
	Bag bag;
	boolean inQueue = false;
	
	public Customer (Random rand) {
		if (!inQueue)
			bag = new Bag(rand);
	}
	
	public void addToBag(Product product) {bag.add(product); }
	
	public void joinQueue() {
		if (!inQueue)
			inQueue = true;
	}
	
	public boolean isInQueue() {return inQueue;}
	
	public int getBagPrice(int hourOfDay) {return bag.getBagPrice(hourOfDay);}
	
	public abstract void advanceInQueue(int place);
	
}
