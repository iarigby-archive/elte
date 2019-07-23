package main;

import train.DiningCar;
import train.FirstClassWagon;
import train.Locomotive;
import train.OverOccupiedException;
import train.SecondClassWagon;
import train.SleepingCar;
import train.Train;

public class Main {
    
    public static void main(String[] args) {
        // Train, locomotive, wagon, first class, second class,
        // dining car, sleeping car
        Locomotive locomotive = new Locomotive("NOHAB", "M61");
        Train train = new Train(locomotive, "Budapest - Wien");
        try {
            train.addWagon(new FirstClassWagon(20).setNumberOfPassengers(10));
            train.addWagon(new SecondClassWagon(30).setNumberOfPassengers(20));
            train.addWagon(new SecondClassWagon(30).setNumberOfPassengers(15));
            train.addWagon(new DiningCar(15).setNumberOfPassengers(10));
            train.addWagon(new SleepingCar(20).setNumberOfPassengers(10));
        } catch (OverOccupiedException ex) {
            System.out.println(ex.getWagon() + " is over-occupied!");
        }
        System.out.println(train);
        System.out.println("Free capacity: " + train.getFreeCapacity());
        System.out.println("Free seats:    " + train.getNumOfFreeSeats());
        System.out.println("Free beds:     " + train.getNumOfFreeBeds());

        /*
         * The correct output result looks like: Train "Budapest - Wien" has a NOHAB M61
         * locomotive and the following cars: First class wagon [10 of 20 seats are
         * occupied] Second class wagon [20 of 30 seats are occupied] Second class wagon
         * [15 of 30 seats are occupied] Dining car [10 of 15 seats are occupied]
         * Sleeping car [10 of 20 beds are occupied]
         * 
         * Free capacity: 50 Free seats: 40 Free beds: 10
         */
    }
    
}
