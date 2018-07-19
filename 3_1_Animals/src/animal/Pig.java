package animal;

import animal.food.Food;

public class Pig extends Animal{
	private String name;	
	
	public Pig(String name) {
		super("piglet");
		this.name = name;
	}
	
	public void feed(Food food) {
		for (int i=0; i<3; i++)
			super.feed(food);
	}
	
	public void printMessage(Food food) {
		System.out.println("Our lovely " + species + ", " + name + ", gets: " + food);
	}
}
