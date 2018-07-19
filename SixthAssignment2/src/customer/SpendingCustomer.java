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

package customer;

import shop.Item;

public class SpendingCustomer extends Customer {
	private int credit;

	public SpendingCustomer(Wallet wallet, int credit) {
		super(wallet);
		this.credit = credit;
	}

	@Override
	public boolean buy(Item item, int amount) {

		if (!super.buy(item, amount)) {
			int spent = 0;
			int i = 0;
			while (spent + item.getPrice() <= wallet.getMoney() + credit && i < amount) {
				spent += item.getPrice();
				i++;
			}
			if (i == 0) {
				return false;
			} else {
				credit += wallet.getMoney() - spent;
				wallet.takeMoney(wallet.getMoney());
			}
		}
		return true;

	}

	public int getCredit() {
		return credit;
	}

}
