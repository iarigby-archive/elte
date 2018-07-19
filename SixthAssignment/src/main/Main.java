/*
> %% Ia Mgvdliashvili
>
> %% OVQXYE
>
> %% Practical Software Engineering I , Sixth Assignment
>
> %% 2017.10.26
>
> %% This solution was submitted and prepared by Ia Mgvdliashvili , OVQXYE for the
> Sixth assignment of the Practical Software Engineering course.
>
> %% I declare that this solution is my own work.
>
> %% I have not copied or used third party solutions.
>
> %% I have not passed my solution to my classmates, neither  made it public.
>
> %% Students’ regulation of Eötvös Loránd University (ELTE Regulations
> Vol. II. 74/C. § ) states that as long as a student presents another
> student’s work - or at least the significant part of it - as his/her own
> performance, it will count as a disciplinary fault. The most serious

> consequence of a disciplinary fault can be dismissal of the student from
> the University."

*/

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
