package service;

import java.util.Random;

public class PatientCustomer extends Customer{

	public PatientCustomer(Random rand) {
		super(rand);
	}
	
	public void advanceInQueue(int place) {
		if (place == 0)
			inQueue = false;
	}
}
