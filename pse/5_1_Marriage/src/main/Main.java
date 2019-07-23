package main;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import marriage.Marriage;
import marriage.Person;
import marriage.Sex;
import marriage.WeddingPresent;
import marriage.exception.BigamousPersonException;
import marriage.exception.UnmarriedButWannaDivorceException;

public class Main {

    public static void main(String[] args) throws BigamousPersonException {
        Person George = new Person(Sex.MALE, "George", "12345ASD", "999999 SmallTown, Flower street 9.");
        Person Julia = new Person(Sex.FEMALE, "Julia", "12345DSA", "999999 SmallTown, Flower street 9.");
        Person Tom = new Person(Sex.MALE, "Tom", "98765EFG", "999999 SmallTown, Flower street 13.");
        Person Anne = new Person(Sex.FEMALE, "Anne", "98765EFH", "999999 SmallTown, Flower street 13.");

        Marriage marriageGJ = marryGJ(George, Julia, Tom, Anne);
        Marriage marrigeTA = marryTA(George, Julia, Tom, Anne);

        for (Marriage marriage : Arrays.asList(marriageGJ, marrigeTA)) {
            marriage.sanction();
            printMarriage(marriage);
        }

        List<Person> people = Arrays.asList(George, Julia, Anne, Tom);
        printSpouses(people);

        try {
            new Marriage(George, Anne, Tom, Julia, "999999 SmallTown, Nobody knows where square 112.",
                    Date.valueOf("2013-03-19")).sanction();
        } catch (BigamousPersonException e) {
            System.out.println("-------------");
            System.out.println("Come on George and Anne, you don't want to do this...");
        }
        tryDivorce(marriageGJ);

        System.out.println("-----------");
        System.out.println("After the divorce of George and Julia:");
        System.out.println("-----------");

        printSpouses(people);

        tryDivorce(marriageGJ);
    }

    private static Marriage marryTA(Person George, Person Julia, Person Tom, Person Anne) {
        Marriage marrigeTA = new Marriage(Tom, Anne, George, Julia, "999999 SmallTown, Nobody knows where square 112.",
                Date.valueOf("2011-03-22"));

        WeddingPresent giftGJ = new WeddingPresent("Pram");
        giftGJ.addDonator(George);
        giftGJ.addDonator(Julia);
        marrigeTA.addWeddingPresent(giftGJ);

        WeddingPresent giftGeorge = new WeddingPresent("Chocolate fountain");
        giftGeorge.addDonator(George);
        marrigeTA.addWeddingPresent(giftGeorge);

        WeddingPresent giftJulia = new WeddingPresent("Lot of plushies");
        giftJulia.addDonator(Julia);
        marrigeTA.addWeddingPresent(giftJulia);
        return marrigeTA;
    }

    private static Marriage marryGJ(Person George, Person Julia, Person Tom, Person Anne) {
        Marriage marriageGJ = new Marriage(George, Julia, Tom, Anne, "999999 SmallTown, Nobody knows where square 112.",
                Date.valueOf("2011-03-19"));

        WeddingPresent giftToGJ = new WeddingPresent("Coffee Maker");
        giftToGJ.addDonator(Tom);
        giftToGJ.addDonator(Anne);
        marriageGJ.addWeddingPresent(giftToGJ);

        WeddingPresent giftTom = new WeddingPresent("Toaster");
        giftTom.addDonator(Tom);
        marriageGJ.addWeddingPresent(giftTom);

        WeddingPresent giftAnne = new WeddingPresent("Holiday trip");
        giftAnne.addDonator(Anne);
        marriageGJ.addWeddingPresent(giftAnne);
        return marriageGJ;
    }

    private static void printMarriage(Marriage marriage) {
        System.out.println(marriage.getHusband().getName() + " and " + marriage.getWife().getName() + " married at "
                + marriage.getPlaceOfMarriage() + " on " + marriage.getDateOfMarriage() + " in front of "
                + marriage.getHusbandsWitness().getName() + " and " + marriage.getWifesWitness().getName());
        System.out.println("They got the following presents:");
        for (WeddingPresent present : marriage.getWeddingPresents()) {
            System.out.println(present);
        }
        System.out.println("");
    }

    private static void printSpouses(List<Person> people) {
        for (Person person : people) {
            Person spouse = person.getSpouse();
            String nameOfSpouse = (spouse == null) ? "none" : spouse.getName();
            System.out.println(person.getName() + "'s spouse: " + nameOfSpouse);
        }
    }

    private static void tryDivorce(Marriage marriage) {
        try {
            marriage.divorce();
        } catch (UnmarriedButWannaDivorceException e) {
            System.out.println("----------");
            System.out.println("George and Julia are already divorced, and they want to do divorce again. "
                    + "They can not hate each other that much...");
        }
    }

}
