package model;

public class Display {
	public static synchronized void display(String s) {
		System.out.println(s);
	}
}
