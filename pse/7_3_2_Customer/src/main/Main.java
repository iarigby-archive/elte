package main;

import java.util.Random;

import service.AngryCustomer;
import service.Apple;
import service.Bread;
import service.CashDesk;
import service.Customer;
import service.Milk;
import service.PatientCustomer;
import service.Product;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random(0);

        CashDesk desk = new CashDesk();

        Customer angry1 = new AngryCustomer(2, rand);
        Customer angry2 = new AngryCustomer(5, rand);
        Customer patient1 = new PatientCustomer(rand);
        Customer patient2 = new PatientCustomer(rand);

        Product apple = new Apple();
        Product bread = new Bread();
        Product milk = new Milk(rand);

        angry1.addToBag(apple);
        angry1.addToBag(bread);
        angry1.addToBag(bread);

        angry2.addToBag(milk);
        angry2.addToBag(bread);

        patient1.addToBag(apple);
        patient1.addToBag(milk);
        patient1.addToBag(bread);

        patient2.addToBag(apple);
        patient2.addToBag(apple);

        System.out.println("19 p.m.");
        System.out.println("angry1: " + angry1.getBagPrice(19));
        System.out.println("angry2: " + angry2.getBagPrice(19));
        System.out.println("patient1: " + patient1.getBagPrice(19));
        System.out.println("patient2: " + patient2.getBagPrice(19));

        System.out.println("21 p.m.");
        System.out.println("angry1: " + angry1.getBagPrice(21));
        System.out.println("angry2: " + angry2.getBagPrice(21));
        System.out.println("patient1: " + patient1.getBagPrice(21));
        System.out.println("patient2: " + patient2.getBagPrice(21));

        desk.joinQueue(patient1);
        desk.joinQueue(angry2);
        desk.joinQueue(patient2);
        desk.joinQueue(angry1);

        System.out.println("people in queue: " + desk.peopleInQueue());

        desk.advanceQueue();
        System.out.println("angry1: " + angry1.getBagPrice(21));
        System.out.println("angry2: " + angry2.getBagPrice(21));

        System.out.println("people in queue: " + desk.peopleInQueue());

        desk.advanceQueue();
        System.out.println("people in queue: " + desk.peopleInQueue());

        desk.advanceQueue();
        System.out.println("people in queue: " + desk.peopleInQueue());
    }

}
