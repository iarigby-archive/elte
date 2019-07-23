package main;

import java.util.Arrays;

public class Calculator {

	public static String SEPARATOR = ",";
	private int multiplier;
	private final int[] array;

	public Calculator(int[] array, int multiplier) {
		this.multiplier = multiplier;
		this.array = array;
	}

	public int[] calculate() {
		int[] result = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[i] * multiplier;
		}
		return result;
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}

	public static void printResult(int[] intArray) {
		System.out.println(Arrays.toString(intArray));
	
	}

	public static void main(String[] args) {
		if (args.length == 2) {
			int[] arrayArgument = convertStringToArray(args[0], Calculator.SEPARATOR);
			Calculator calc = new Calculator(arrayArgument, Integer.parseInt(args[1]));
			printResult(calc.calculate());
			calc.setMultiplier(-1);
			printResult(calc.calculate());
		} else {
			System.err.println("An error occurred, the number of the arguments is not 2.");
		}
	}

	public static int[] convertStringToArray(String argument, String separator) {
		String[] parts = argument.split(separator);
		int[] result = new int[parts.length];
		for (int i = 0; i < parts.length; i++) {
			result[i] = Integer.parseInt(parts[i]);
		}
		return result;
	}

}
