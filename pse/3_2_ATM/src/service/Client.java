package service;

public class Client {
	BankCard bankCard;
	
	public Client(BankCard bankCard) {
		this.bankCard = bankCard;
	}
	
	public boolean withdraw(int pin, int amount) {
		if (this.bankCard.authorize(pin)) {
			if (amount <= this.bankCard.acc.getBalance()) {
				bankCard.acc.changeBalance(amount);
				return true;
			}
		}
			
		return false;
	}
}
