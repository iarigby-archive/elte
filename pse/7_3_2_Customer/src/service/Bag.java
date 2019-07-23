package service;

import java.util.List;
import java.util.Random;
import java.util.*;

public class Bag {

	private List<Product> products = new ArrayList<Product>();
	private Random rand;
	
	public Bag(Random rand) {
		this.rand = rand;
	}
	
	public void add(Product product) { products.add(product); }
	
	public void removeRandom() { products.remove(rand.nextInt(products.size())); }
	
	public int getBagPrice(int hourOfDay) {
		int sum = 0;
		for (Product product : products)
			sum += product.getPrice()*(1 - product.getDiscount(hourOfDay));
		return sum;
	}
	
}
