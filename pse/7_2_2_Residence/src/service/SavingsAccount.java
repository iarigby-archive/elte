package service;

public class SavingsAccount {

	private int balance;
	private double interestRate;
	
	public SavingsAccount(double interestRate) {
		this.interestRate = interestRate;
		balance = 0;
	}
	
	public void deposit(int amount) { balance += amount; }
	
	public void payInterest() { balance += balance*interestRate;}// (1+interestRate); }
	
	public int getBalance() { return balance; }
	
	
}
