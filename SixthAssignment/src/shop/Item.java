/*
> %% Ia Mgvdliashvili
>
> %% OVQXYE
>
> %% Practical Software Engineering I , Second Exam
>
> %% 2017.12.19
>
> %% This solution was submitted and prepared by Ia Mgvdliashvili , OVQXYE for the
> Second  of the Practical Software Engineering course.
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

package shop;

public class Item {
	private String name;
	private int price;
	
	public Item(String n, int p) {
		name = n;
		price = p;
	}
	
	public int getPrice() {return price;}
	public String getName() {return name;}
}
