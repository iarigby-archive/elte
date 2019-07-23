package service;

import java.util.Random;

public class Milk implements Product{
	private int limit;
	
	public Milk(Random rand) { this.limit = rand.nextInt(5)+17;}
	
	public int getPrice() { return 150; }
	
	public float getDiscount(int hourOfDay) {
		if (hourOfDay > limit) 
			return 0.3f;
		else
			return 0;
	}
	
}
