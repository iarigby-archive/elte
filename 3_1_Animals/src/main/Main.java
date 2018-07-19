package main;

import animal.Animal;
import animal.Fish;
import animal.Pig;
import animal.food.Apple;

public class Main {

    public static void main(String[] args) {
        Animal fish = new Fish();
        fish.feed(new Fish());

        Animal pig = new Pig("Tomcsi");
        pig.feed(new Apple());
    }

}
