package main;

import service.Bus;
import service.Car;

public class Main {

    public static void main(String[] args) {
        new Car("car1", 12.0, 73.4).start();
        new Car("car2", 12.0, 120.9).start();
        new Bus("bus1", 120.0, 730.4).start();
        new Bus("bus2", 120.0, 1200.923).start();
    }

}
