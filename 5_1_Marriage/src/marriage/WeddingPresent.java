package marriage;

import java.util.*;

public class WeddingPresent {
	private String giftName;
	private ArrayList<Person> donators;
	
	public WeddingPresent(String name) {
		giftName = name;
		donators = new ArrayList<Person>();
	}
	
	public void addDonator(Person person) {
		donators.add(person);
	}
	
	public String toString() {
		return giftName;
	}

}
