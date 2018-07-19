package main;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import house.Flat;
import house.Floor;
import house.House;
import house.Staircase;

public class Main {

    public static void main(String[] args) {
        Staircase staircase = new Staircase(1);
        Flat flat1 = new Flat(1);
        Flat flat2 = new Flat(2);
        Flat flat3 = new Flat(3);
        Flat flat4 = new Flat(4);
        Flat flat5 = new Flat(5);
        Flat flat6 = new Flat(6);
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        House house = new House(staircase);

        flat1.addNeighbour(flat2);
        flat2.addNeighbour(flat1);

        flat3.addNeighbour(flat4);
        flat3.addNeighbour(flat5);
        flat4.addNeighbour(flat3);
        flat4.addNeighbour(flat5);
        flat5.addNeighbour(flat3);
        flat5.addNeighbour(flat4);
        flat5.addNeighbour(flat6);
        flat6.addNeighbour(flat5);

        floor1.addStaircase(staircase);
        floor1.addFlat(flat1);
        floor1.addFlat(flat2);
        floor2.addFlat(flat3);
        floor2.addFlat(flat4);
        floor2.addFlat(flat5);

        staircase.addFloor(floor1);
        staircase.addFloor(floor2);

        house.addFloor(floor1);
        house.addFloor(floor2);
        house.addStaircase(staircase);

        List<Floor> floors = house.getFloors();
        Set<Staircase> staircases = house.getStaircases();
        int f = floors.size();
        int s = staircases.size();

        System.out.println("There are " + f + " floors and " + s + " staircase(s) in this house.");

        for (Floor floor : floors) {
            Set<Flat> flats = floor.getFlats();
            System.out.println("We can find " + flats.size() + " flats on " + floor + ".");

            for (Flat flat : flats) {
                int neighbours = flat.numberOfNeighbours();
                System.out.print(flat + " has " + neighbours + " neighbour(s)");
                if (neighbours > 0)
                    System.out.print(" (" + flat.getFirstNeighbour());
                if (neighbours > 1)
                    System.out.print(", " + flat.getSecondNeighhour());
                if (neighbours > 0)
                    System.out.print(")");
                System.out.println(".");
            }
        }

        for (Staircase sc : house.getStaircases()) {
            System.out.print(sc + " joins the following floors: ");
            System.out.println(sc.getFloors().stream().map(Floor::toString).collect(Collectors.joining(", ")));
        }

        /*
         * The correct output is:
         * 
            There are 2 floors and 1 staircase(s) in this house.
            We can find 2 flats on Floor-1.
            Flat-1 has 1 neighbour(s) (Flat-2).
            Flat-2 has 1 neighbour(s) (Flat-1).
            We can find 3 flats on Floor-2.
            Flat-3 has 2 neighbour(s) (Flat-4, Flat-5).
            Flat-5 has 3 neighbour(s) (Flat-3, Flat-4).
            Flat-4 has 2 neighbour(s) (Flat-3, Flat-5).
            Staircase-1 joins the following floors: Floor-1, Floor-2
         */

        /*
       
        for (String err : house.validate()) {
            System.err.println(err);
        }
       
       
         * 
         * 
         * The correct error list is: (it appears in red)
         * 
         * There is not any staircase belongs to Floor-2 There are too much neighbours
         * for Flat-5 at Floor-2
         */
    }

}
