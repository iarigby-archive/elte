package main;

import service.DivisionService;

public class DivisionServiceDemo {
	public static void main(String[] args) {
		DivisionService divisionService = new DivisionService();
		
		divisionService.setNumerator(3.0);
		divisionService.setDenominator(6.0);
		
		if (divisionService.isDivisible()) {
			System.out.println(divisionService.getNumerator() + " / " + 
							divisionService.getDenominator() + " = " + 
							divisionService.getDivision());
		}
	}
}
