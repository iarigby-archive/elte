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

package main;

import service.LineEnding;
import service.LinesConcatter;

public class Main {

    public static void main(String[] args) {
        String[] lines = new String[2];
        lines[0] = "This is the first line.";
        lines[1] = "This is the second line.";

        String concattedLines = LinesConcatter.concatLines(lines, LineEnding.UNIX);
        System.out.println(concattedLines);

        System.out.println(LinesConcatter.replaceLineEndings(concattedLines, LineEnding.UNIX, LineEnding.WINDOWS));
    }

}
