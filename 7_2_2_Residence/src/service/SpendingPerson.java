package service;

public class SpendingPerson extends Person{

	public SpendingPerson(SavingsAccount savingsAccount, Residence residence) {
		super(savingsAccount, residence);
	}
	
	public void spend(int residenceCosts) {
		
		super.spend(residenceCosts);
		if (cash >= 50000) {
			savingsAccount.deposit(10000);
			cash -= 10000;
		}
			
	}
	
	
}
