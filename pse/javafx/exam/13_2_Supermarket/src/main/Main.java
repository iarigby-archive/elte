package main;

import model.Cashier;
import model.Supermarket;

public class Main {

    public static void main(String[] args) {
        Supermarket sm = new Supermarket(3);
        sm.addCashier(new Cashier(sm, "Bob", 10, 100, 50));
        sm.addCashier(new Cashier(sm, "Rob", 10, 100, 50));
        sm.addCashier(new Cashier(sm, "Roy", 10, 100, 50));
        sm.addCashier(new Cashier(sm, "Tom", 10, 100, 50));
        sm.addCashier(new Cashier(sm, "Bob2", 10, 100, 50));
    }

}
