package main;

import service.OwnedResidence;
import service.Person;
import service.RentedResidence;
import service.Residence;
import service.SavingPerson;
import service.SavingsAccount;
import service.SpendingPerson;

public class Main {

    public static void main(String[] args) {
        Residence aResidence = new RentedResidence();
        Person albert = new SavingPerson(new SavingsAccount(0.007), aResidence);
        OwnedResidence bResidence = new OwnedResidence(20000000, -60000000);
        Person beatrice = new SpendingPerson(new SavingsAccount(0.006), bResidence);
        int month = 0;
        while (bResidence.hasLoan()) {
            albert.earn(280000);
            albert.spend(200000);
            beatrice.earn(285000);
            beatrice.spend(215000);
            ++month;
        }

        System.out.println(month); // prints "280"
        System.out.println(albert.getEquity()); // prints "34576817"
        System.out.println(beatrice.getEquity()); // prints "27230799"
    }
}
