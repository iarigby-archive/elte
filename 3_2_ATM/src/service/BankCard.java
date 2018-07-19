package service;

public class BankCard implements Card {
	private int pin;
	Account acc;
	
	public BankCard(int pin, Account acc) {
		this.pin = pin;
		this.acc = acc;
	}
	
	public boolean authorize(int pin) {
		return pin == this.pin;
	}
	
	
}
