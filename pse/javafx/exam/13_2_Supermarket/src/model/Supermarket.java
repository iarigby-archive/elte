package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Supermarket {
	private List<Cashier> cashiers = new ArrayList<Cashier>();
	private Set<Integer> freeCashDesks = new HashSet<Integer>();
	private Map<Cashier, Integer> cashDesks = new HashMap<Cashier, Integer>();
	
	public Supermarket(int n) {
		for (int i = 0; i < n; i++) freeCashDesks.add(i);
	}
	
	public void addCashier(Cashier cashier) {
		cashiers.add(cashier);
	}
	
	
	public synchronized int getCashDesk(Cashier cashier) {
		while (freeCashDesks.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return 0;
			}
		}
		int freeDesk = freeCashDesks.iterator().next();
		freeCashDesks.remove(freeDesk);
		cashDesks.put(cashier, freeDesk);
		return freeDesk;
	}
	
	public void cashierLeaves(Cashier cashier) {
		boolean trouble = true;
		freeCashDesks.add(cashDesks.get(cashier));
		cashDesks.remove(cashier);
		cashiers.notifyAll();
		for (Cashier c : cashiers) {
			if (!c.getState().equals(CashierState.TAKING_REST)) {
				trouble = false;
				break;
			}
		}
		if (trouble) {
			Display.show("Supermarket is in trouble");
			for (Cashier c : cashiers) 
				c.closeShop();
		}
	}
}
