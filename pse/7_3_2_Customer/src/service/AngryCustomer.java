package service;

import java.util.Random;

public class AngryCustomer extends Customer{

	int tolerance;
	int counter = 0;
	
	public AngryCustomer(int tolerance, Random rand) {
		super(rand);
		this.tolerance = tolerance;
	}
	
	public void advanceInQueue(int place) {
		if (place > 0 ) {
			bag.removeRandom();
			counter++;
			if (counter == tolerance) {
				inQueue = false;
			}
		} else {
			inQueue = false;
		}
	}
	
}
