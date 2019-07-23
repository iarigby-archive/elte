package service;

public class Bread implements Product{

	public int getPrice() { return 200;}
	
	public float getDiscount(int hourOfDay) {
		if (hourOfDay >= 20 && hourOfDay <= 24)
			return 0.1f;
		else
			return 0;
	}
}
