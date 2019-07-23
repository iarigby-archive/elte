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

package main;

import service.ConditionalMaxSearch;
import service.Predicate;
import service.Summation;
import service.ValueSequence;

public class Main {

    private static Predicate<Integer> divisibleByFive = value -> value % 5 == 0;

    public static void main(String[] args) {
        ValueSequence<Integer> seq = new ValueSequence<>();
        seq.add(4);
        seq.add(5, 6, 3, 10, 8, 5, 1);
        System.out.println("Sequence: " + seq);
        System.out.println("Sum: " + seq.calculate(new Summation()));
        System.out.println("Max value divisible by 5: " + seq.calculateMaybeEmpty(new ConditionalMaxSearch(divisibleByFive)));
    }

}
