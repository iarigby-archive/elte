package service;

import java.util.*;

public class CashDesk {

	private List<Customer> queue = new ArrayList<Customer>();
	
	public void joinQueue(Customer customer) { queue.add(customer);}
	
	public int peopleInQueue() {return queue.size();}
	
	public void advanceQueue() {
		queue.get(0).advanceInQueue(0);
		queue.remove(0);
	}
	
}
