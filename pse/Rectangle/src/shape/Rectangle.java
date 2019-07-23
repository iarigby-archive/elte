package shape;

public class Rectangle {
	private final double a;
	private final double b;
	
	
	public Rectangle(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public double getA() {
		return a;
	}
	
	public double getB() {
		return b;
	}
	
	public double getArea() {
		return a*b;
	}
}
