package model;

public class Display {

    public static synchronized void show(String s) {
        System.out.println(s);
    }

}
