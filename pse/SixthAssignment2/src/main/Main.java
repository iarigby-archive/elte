package main;

import customer.Customer;
import customer.SavingCustomer;
import customer.SpendingCustomer;
import customer.Wallet;
import shop.Item;

public class Main {
	public static void main(String[] args) {
		Wallet w1 = new Wallet(20_000);
		Wallet w2 = new Wallet(20_000);

		SpendingCustomer spendingCustomer = new SpendingCustomer(w1, 5000);
		Customer savingCustomer = new SavingCustomer(w2);

		Item apple = new Item("apple", 12);
		Item axe = new Item("axe", 1250);

		savingCustomer.buy(apple, 11);
		savingCustomer.buy(axe, 1200);

		spendingCustomer.buy(apple, 11);
		spendingCustomer.buy(axe, 1200);

		if (w1.getMoney() != 0 || spendingCustomer.getCredit() != 1118 || w2.getMoney() != 19868) {
			System.out.println("Wrong solution");
		} else {
			System.out.println("Correct solution!");
		}
	}
}
