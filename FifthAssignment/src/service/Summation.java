/*
> %% Ia Mgvdliashvili
>
> %% OVQXYE
>
> %% Practical Software Engineering I , Third Assignment
>
> %% 2017.10.09
>
> %% This solution was submitted and prepared by Ia Mgvdliashvili , OVQXYE for the
> Third assignment of the Practical Software Engineering course.
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

package service;

public class Summation implements Operator<Integer> {
	@Override
	public Integer calculate(Integer a, Integer b) {
		if (a == null || b == null) {
			return null;
		} else {
			return a+b;
		}
		
	}
}
