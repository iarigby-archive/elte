package service;

public class SavingPerson extends Person{

	public SavingPerson(SavingsAccount savingsAccount, Residence residence) {
		super(savingsAccount, residence);
	}
	
	public void spend(int residenceCosts) {
		
		super.spend(residenceCosts);
		savingsAccount.deposit(cash/2);
		cash -= cash/2;
	}
	
	
}
