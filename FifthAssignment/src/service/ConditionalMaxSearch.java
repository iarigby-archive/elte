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

public class ConditionalMaxSearch implements Operator<Integer> {
	//<?> condition;
	private Predicate<Integer> condition;
	
	public ConditionalMaxSearch(Predicate<Integer> condition) {
		this.condition = condition;
	}
	
	@Override
	public Integer calculate(Integer a, Integer b) {
		if (a==null && b==null) {
			return null;
		} else if (a == null ^ b == null) {
			if (a == null) {
				return b;
			} else {
			return a;
			}
		} else {
			if (!condition.test(a) &&  !condition.test(b)) {
				return null;
			} else if (condition.test(a) ^ condition.test(b)) {
				if (condition.test(a)) {
					return a;
				} else {
					return b;
				}
			} else {
				if ( a > b) {
					return a;
				} else {
					return b;
				}
			}
		}
	}
}
