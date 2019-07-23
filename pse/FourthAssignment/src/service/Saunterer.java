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

public class Saunterer extends Being{
	public Saunterer(String name, int supply) {
		super(name, supply, "Saunterer");
		this.maxValue = 12;
		
		this.waterSunny = -2;
		this.waterCloudy = -1;
		this.waterRainy = 3;
		this.distanceSunny = 1;
		this.distanceCloudy = 2;
		this.distanceRainy = 1;
	}
	
}
