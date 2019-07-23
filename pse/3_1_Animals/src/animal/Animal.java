package animal;

import java.util.ArrayList;

import animal.food.Food;



public abstract class Animal {
	public String species;
	public ArrayList<Food> eatenFoods = new ArrayList<>();
	
	public Animal(String species) {
		this.species = species;
	}
	
	public void feed(Food food) {
		eatenFoods.add(food);
		printMessage(food);
	}
	
	public void printMessage(Food food) {
		System.out.println("Our " + species + " gets: " + food);
	}
}
