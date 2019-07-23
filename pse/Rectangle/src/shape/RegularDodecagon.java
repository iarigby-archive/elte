package shape;

public class RegularDodecagon {
	private final double a;
	
	public RegularDodecagon(double a) {
		this.a = a;
	}

	public double getA() {
		return a;
	}
	
	public double getArea() {
		return 0.5*a*this.getPerimeter();
	}
	
	private double getPerimeter() {
		return 12*a;
	}
}
