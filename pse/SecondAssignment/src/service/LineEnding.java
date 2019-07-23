/*
> %% Ia Mgvdliashvili
>
> %% OVQXYE
>
> %% Practical Software Engineering I , Second Assignment
>
> %% 2017.03.10
>
> %% This solution was submitted and prepared by Ia Mgvdliashvili , OVQXYE for the
> Second assignment of the Practical Software Engineering course.
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

public enum LineEnding {
	UNIX("\n"), WINDOWS("\r\n");
	
	public final String ending;
	
	private LineEnding(String ending) {
		this.ending = ending;
	}
}
