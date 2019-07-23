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

public class Customer {
	protected Wallet wallet;

	public Customer(Wallet w) {
		wallet = w;
	}

	public boolean buy(Item item, int amount) {
		if (item.getPrice() * amount <= wallet.getMoney()) {
			wallet.takeMoney(item.getPrice() * amount);
			return true;
		}
		return false;
	}

}
