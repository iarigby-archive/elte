package service;

public class DivisionService {
	private double Numerator;
	private double Denominator;
	
	public boolean isDivisible() {
		return Numerator % Denominator == 0;
	}

	public double getNumerator() {
		return Numerator;
	}

	public void setNumerator(double numerator) {
		Numerator = numerator;
	}

	public double getDenominator() {
		return Denominator;
	}

	public void setDenominator(double denominator) {
		Denominator = denominator;
	}
	
	public double getDivision() {
		return Numerator / Denominator;
	}
} 
