package service;


public class OwnedResidence implements Residence {

	private int totalValue;
	private int loan;
	
	public OwnedResidence(int totalValue, int loan) {
		this.totalValue = totalValue;
		this.loan = loan;
	}
	
	public void pay(int cost) { loan += cost; }
	
	public int getValue() {return totalValue + loan;}
	
	public boolean hasLoan() { return loan < 0;}
	
	
}
