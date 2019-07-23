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

import geometry.Movable;
import geometry.Point;
import geometry.Polygon;
import geometry.Quadrilateral;
import geometry.Vector;

public class Main {

    public static void main(String[] args) {
        Point x = new Point(0, 0);
        Point y = new Point(1.2, -3);

        Vector v1 = new Vector(0.5, 0.5);

        Polygon p = new Polygon(x, y);
        p.move(v1);
        System.out.println(p); // Polygon [points=[(x=0.5, y=0.5), (x=1.7, y=-2.5)]]

        Point a = new Point(3.2, 4);
        Point b = new Point(1, 2.4);
        Point c = new Point(0, 0);
        Point d = new Point(-1.5, 2);

        Vector v = new Vector(1, -1.23);

        Movable m = new Quadrilateral(a, b, c, d);
        m.move(v);
        System.out.println(m); // Polygon [points=[(x=4.2, y=2.77), (x=2.0, y=1.17), (x=1.0, y=-1.23), (x=-0.5,
                               // y=0.77)]]
    }

}
