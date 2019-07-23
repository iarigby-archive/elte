package main;

// ctrl + shift + o
import shape.Circle;
import shape.Rectangle;
import shape.RegularDodecagon;

public class Main {
	public static void main(String args[]) {
		Rectangle r = new Rectangle(12.4, 13.4);
		Circle c = new Circle(3.0);
		RegularDodecagon d = new RegularDodecagon(4.0);
		System.out.println(r.getArea());
		System.out.println(c.getArea());
		System.out.println(d.getArea());
		
	}
	
	
}
