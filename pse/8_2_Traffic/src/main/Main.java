package main;

import java.util.Arrays;
import java.util.Random;

import traffic.BeginnerPassenger;
import traffic.Bus;
import traffic.BusStop;
import traffic.IntermediatePassenger;
import traffic.Passenger;
import traffic.ProfessionalPassenger;
import traffic.Route;

public class Main {

    public static void main(String[] args) {
        BusStop a = new BusStop("A");
        BusStop b = new BusStop("B");
        BusStop c = new BusStop("C");

        Route route = new Route();
        route.addStop(a).addStop(b).addStop(c);

        Passenger b1 = new BeginnerPassenger("b1", b);
        Passenger b2 = new BeginnerPassenger("b2", c);
        Passenger b3 = new BeginnerPassenger("b3", b);
        Passenger b4 = new BeginnerPassenger("b4", b);
        Passenger b5 = new BeginnerPassenger("b5", b);

        Passenger i1 = new IntermediatePassenger("i1", b);
        Passenger i2 = new IntermediatePassenger("i2", c);
        Passenger i3 = new IntermediatePassenger("i3", c);

        Random rnd = new Random();

        Passenger p1 = new ProfessionalPassenger("p1", b, rnd);
        Passenger p2 = new ProfessionalPassenger("p2", c, rnd);

        a.addPassenger(b1).addPassenger(b3).addPassenger(b5).addPassenger(p1).addPassenger(i1).addPassenger(i3).addPassenger(b4);

        b.addPassenger(b2).addPassenger(i2).addPassenger(p2);

        Bus bus = new Bus(3);

        System.out.println(a);
        // BusStop [name=A, passengers=[{name=b1}, {name=b3}, {name=b5}, {name=p1}, {name=i1}, {name=i3}, {name=b4}]]

        System.out.println(b);
        // BusStop [name=B, passengers=[{name=b2}, {name=i2}, {name=p2}]]

        System.out.println(c);
        // BusStop [name=C, passengers=[]]

        route.travelByBus(bus);
        System.out.println("\n\n********************\n");
        route.travelByBus(bus);

        System.out.println(a);
        // BusStop [name=A, passengers=[{name=b4}]]

        System.out.println(b);
        // BusStop [name=B, passengers=[]]

        System.out.println(c);
        // BusStop [name=C, passengers=[]]

        Arrays.asList(b1, b2, b3, b4, b5, i1, i2, i3, p1, p2).forEach(x -> {
            BusStop g = x.getGotOffAt();
            System.out.format("%s got off at %s\n", x.getName(), g == null ? "none" : g.getName());
        });
        // Should print something like this (depends on random):
        // b1 got off at A
        // b2 got off at C
        // b3 got off at B
        // b4 got off at none
        // b5 got off at B
        // i1 got off at B
        // i2 got off at B
        // i3 got off at C
        // p1 got off at B
        // p2 got off at C
    }

}
