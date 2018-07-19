package model;

import java.util.Random;

public class Cashier implements Runnable {
	private CashierState state;
	private int speed;
	private int restTime;
	private int workTime;
	private Supermarket supermarket;
	private Thread thread;
	private String name;
	
	public Cashier(Supermarket supermarket, String name, int speed, int restTime, int workTime) {
		this.state = CashierState.FREE;
		//TODO new thread
		this.thread = new Thread(this);
		this.speed = speed;
		this.restTime = restTime;
		this.workTime = workTime;
		this.supermarket = supermarket;
		this.name = name;
	}
	
	@Override
	public void run() {
		int workedTime = 0;
		int deskNumber = 0;
		state = CashierState.FREE;
		while (!thread.isInterrupted()) {
			if (state.equals(CashierState.FREE)) {
				deskNumber = supermarket.getCashDesk(this);
				if (deskNumber == 0) thread.interrupt(); //TODO
				else {
					Display.show(this.name);
					state = CashierState.BUSY;
				}
			} else {
				workedTime += ((new Random()).nextInt(5) + 5)*speed;
				if (workedTime > workTime) {
					Display.show(name + " has a break now!");
					state = CashierState.TAKING_REST;
					workedTime = 0;
					supermarket.cashierLeaves(this);
					try {
						Thread.sleep(restTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					state = CashierState.FREE;
					Display.show(name + " finished break and is free again!");
				}
			}
		}
		Display.show("It's time to go home for " + name);
		
	}
	
	public void closeShop() {
		thread.interrupt();
	}
	
	public CashierState getState() {
		synchronized (this) {
			return state;
		}
	}
	
	
}
