/*
> %% Ia Mgvdliashvili
>
> %% OVQXYE
>
> %% Practical Software Engineering I , Fourth Assignment
>
> %% 2017.10.15
>
> %% This solution was submitted and prepared by Ia Mgvdliashvili , OVQXYE for the
> Fourth assignment of the Practical Software Engineering course.
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

public class Saunterer extends Being {
	private final static int[] waterValues = {-2, -1, 3};
	private final static int[] distanceValues = {1, 2, 1};
	private final static int maxSupply = 12;
	
	public Saunterer(String name, int supply) {
		super(name, supply, maxSupply, waterValues, distanceValues);
	}
}
