/*
> %% Ia Mgvdliashvili
>
> %% OVQXYE
>
> %% Practical Software Engineering I , First test
>
> %% 2017.11.14
>
> %% This solution was submitted and prepared by Ia Mgvdliashvili , OVQXYE for the
> First test of the Practical Software Engineering course.
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

import service.CodeUtils;

public class Main {
    
    public static void main(String[] args) {
        System.out.println(CodeUtils.decimalToString(53));
        System.out.println(CodeUtils.decimalToString(206));
        System.out.println(CodeUtils.decimalToString(4));
        System.out.println(CodeUtils.decimalToString(13));
        System.out.println(CodeUtils.decimalToString(191));
        System.out.println(CodeUtils.decimalToString(273));
        System.out.println("----------");
        System.out.println(CodeUtils.stringToDecimal("HEYADANGHAHAHAHA")); // 635375889
        System.out.println(CodeUtils.stringToDecimal("HAHA"));
    }

}
