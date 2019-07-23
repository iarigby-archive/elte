package main;

import service.Account;
import service.BankCard;
import service.Client;

public class Main {

    public static void main(String[] args) {
        Account acc = new Account(25_000);
        Client client = new Client(new BankCard(1234, acc));

        System.out.println(client.withdraw(2222, 10_000));
        System.out.println(client.withdraw(1234, 100_000));
        System.out.println(client.withdraw(1234, 10_000));
        System.out.println(acc.getBalance());
        
    }

}
