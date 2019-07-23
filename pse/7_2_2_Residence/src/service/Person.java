package service;

public class Person {
	int cash;
	Residence residence;
	SavingsAccount savingsAccount;
	
	public Person(SavingsAccount savingsAccount, Residence residence) {
		this.residence = residence;
		this.savingsAccount = savingsAccount;
	}
	
	public void spend(int residenceCosts) { 
		residence.pay(residenceCosts);
		cash-= residenceCosts; 
	}
	
	public void earn(int salary) {
		cash += salary;
		savingsAccount.payInterest();
		
	}
	
	public int getEquity() { 
		return cash + savingsAccount.getBalance() + residence.getValue();
	}
}
