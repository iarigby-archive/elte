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

package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import service.Being;
import service.Day;
import service.SandWalker;
import service.Saunterer;
import service.Sponge;

public class Main {

    public static void main(String[] args) {
        List<Being> competitors = new ArrayList<>();

        competitors.add(new SandWalker("Wanderer", 4));
        competitors.add(new Saunterer("Walk", 7));
        competitors.add(new Sponge("Slippery", 12));
        competitors.add(new Sponge("Sliding", 10));

        // some days are created and then we loop through them, call the tryMove method
        // on each being, for every day
        List<Day> days = Arrays.asList(Day.SUNNY, Day.CLOUDY, Day.CLOUDY, Day.RAINY, Day.SUNNY, Day.SUNNY, Day.SUNNY,
                Day.SUNNY, Day.CLOUDY);

        // once you override the toString method in Being class, it will be much nicer
        // t(h)rust me
        competitors.forEach(System.out::println);
        System.out.println();
        days.forEach(d -> {
            System.out.println("It's a " + d.name() + " day\n------------------------------");
            competitors.forEach(c -> c.tryMove(d));
            System.out.println();
        });

        System.out.println("Results:");
        competitors.forEach(System.out::println);
    }
    
    /* this was my console output, the toString is overridden in my Being type:
    
                    Wanderer is alive, waterSupply is 4 and distance is 0
                    Walk is alive, waterSupply is 7 and distance is 0
                    Slippery is alive, waterSupply is 12 and distance is 0
                    Sliding is alive, waterSupply is 10 and distance is 0
                    
                    It's a SUNNY day
                    ------------------------------
                    Wanderer is alive, waterSupply is 3 and distance is 3
                    Walk is alive, waterSupply is 5 and distance is 1
                    Slippery is alive, waterSupply is 8 and distance is 0
                    Sliding is alive, waterSupply is 6 and distance is 0
                    
                    It's a CLOUDY day
                    ------------------------------
                    Wanderer is alive, waterSupply is 3 and distance is 4
                    Walk is alive, waterSupply is 4 and distance is 3
                    Slippery is alive, waterSupply is 7 and distance is 1
                    Sliding is alive, waterSupply is 5 and distance is 1
                    
                    It's a CLOUDY day
                    ------------------------------
                    Wanderer is alive, waterSupply is 3 and distance is 5
                    Walk is alive, waterSupply is 3 and distance is 5
                    Slippery is alive, waterSupply is 6 and distance is 2
                    Sliding is alive, waterSupply is 4 and distance is 2
                    
                    It's a RAINY day
                    ------------------------------
                    Wanderer is alive, waterSupply is 6 and distance is 5
                    Walk is alive, waterSupply is 6 and distance is 6
                    Slippery is alive, waterSupply is 12 and distance is 5
                    Sliding is alive, waterSupply is 10 and distance is 5
                    
                    It's a SUNNY day
                    ------------------------------
                    Wanderer is alive, waterSupply is 5 and distance is 8
                    Walk is alive, waterSupply is 4 and distance is 7
                    Slippery is alive, waterSupply is 8 and distance is 5
                    Sliding is alive, waterSupply is 6 and distance is 5
                    
                    It's a SUNNY day
                    ------------------------------
                    Wanderer is alive, waterSupply is 4 and distance is 11
                    Walk is alive, waterSupply is 2 and distance is 8
                    Slippery is alive, waterSupply is 4 and distance is 5
                    Sliding is alive, waterSupply is 2 and distance is 5
                    
                    It's a SUNNY day
                    ------------------------------
                    Wanderer is alive, waterSupply is 3 and distance is 14
                    Walk is alive, waterSupply is 0 and distance is 9
                    Slippery is alive, waterSupply is 0 and distance is 5
                    Sliding is not alive, waterSupply is 0 and distance is 5
                    
                    It's a SUNNY day
                    ------------------------------
                    Wanderer is alive, waterSupply is 2 and distance is 17
                    Walk is not alive, waterSupply is 0 and distance is 9
                    Slippery is not alive, waterSupply is 0 and distance is 5
                    
                    It's a CLOUDY day
                    ------------------------------
                    Wanderer is alive, waterSupply is 2 and distance is 18
                    
                    Results:
                    Wanderer is alive, waterSupply is 2 and distance is 18
                    Walk is not alive, waterSupply is 0 and distance is 9
                    Slippery is not alive, waterSupply is 0 and distance is 5
                    Sliding is not alive, waterSupply is 0 and distance is 5
     */

}
