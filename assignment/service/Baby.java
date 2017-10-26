package service;

import java.util.Date;
import java.text.*;
import java.util.ArrayList;

public class Baby {

	private String name;
	private Date birthday;
	private char gender;
	private static SimpleDateFormat myFormat = new SimpleDateFormat("ddMMyyyy HHmm");
	private ArrayList<Gift> gifts = new ArrayList<Gift>();

	public Baby() {
		
	}

	public Baby(String birthday, String name, char gender) throws ParseException {

		this.birthday = myFormat.parse(birthday);
		this.name = name;
		this.gender = gender;
	
	}

	public Baby(Date birthday, String name, char gender) {

		this.birthday = birthday;
		this.name = name;
		this.gender = gender;
	
	}

	


	public int howOld() {

		Date today = new Date();
		long dateDifference = today.getTime() - this.birthday.getTime();
		int days = (int) dateDifference/1000/24/60/60;
		return days;

	}

	public boolean isOlder(Baby baby) { return this.birthday.before(baby.birthday); }
	

	//sorting functions
	
	public static ArrayList<Baby> listByAge(ArrayList<Baby> babies) {
		
		ArrayList<Baby> result = new ArrayList<Baby>(babies);
		
		boolean sorted;
		do {
			sorted = true;
			for (int j = 0; j < result.size()-1; j++) {
				if (result.get(j).birthday.compareTo(result.get(j+1).birthday) < 0 ) {
					result.add(j+2, result.get(j));
					result.remove(j);
					sorted = false;					
				}
			}

		} while (!sorted);

		return result;

	}

	public static ArrayList<Baby> listByName(ArrayList<Baby> babies) {
		
		ArrayList<Baby> result = new ArrayList<Baby>(babies);

		boolean sorted;
		do {
			sorted = true;
			for (int j = 0; j < result.size()-1; j++) {
				if (result.get(j).name.compareTo(result.get(j+1).name) > 0 ) {
					result.add(j+2, result.get(j));
					result.remove(j);
					sorted = false;					
				}
			}

		} while (!sorted);

		return result;
	}

	//helper functions

	public static void printAll(ArrayList<Baby> babies) {

		for (Baby baby : babies) System.out.println(baby);
	}

	

	@Override
	public String toString() {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String birthdate = format.format(this.birthday);

		return name + " " + birthdate;

	}

	public boolean equals(Baby baby) { return this.name.equals(baby.name) && this.birthday == baby.birthday && this.gender == baby.gender;}
	
	public void addGift(String name, String description, String date) throws ParseException { 

		gifts.add(new Gift(name, description, myFormat.parse(date))); 

	}


	public void addGift(String name, String description) { 

		gifts.add(new Gift(name, description, new Date())); 

	}

	public void addGift(Gift gift) {gifts.add(gift);}
 
	public void printGifts() {
		
		System.out.println("Baby " + name + " has following gifts: ");
		for (Gift gift : gifts) {
			System.out.println("\t" + gift);
		}

	}







/*

	//
	//handling gifts
	
	private static ArrayList<Gift> gifts = new ArrayList<Gift>();


	public static void printGifts() {
		
		for (Gift gift : gifts) System.out.println(gift);
	}

	public static ArrayList<Gift> getGifts() { return gifts; }

	public static void addGift(Gift gift) { gifts.add(gift); }


	public static void addGift(String name, String description, String date) throws ParseException { 
		
		gifts.add(new Gift(name, description, myFormat.parse(date))); 
	}

	public static void addGift(String name, String description) { 
		
		gifts.add(new Gift(name, description, new Date())); 
	}
*/

	/*

	//everything else is exactly the same, sort by name is working but age has random order for some reason (not decreasing, not increasing)
	public static ArrayList<Baby> bubbleSort(ArrayList<Baby> babies, String type) {
			
			ArrayList<Baby> result = new ArrayList<Baby>(babies);
			
			boolean isGreater = false;
			boolean sorted;
			do {
				sorted = true;
				for (int j = 0; j < result.size()-1; j++) {
					switch (type) {
						//copied if statement arguments from line 59 and 80
						case "age":
							isGreater = result.get(j).birthday.compareTo(result.get(j+1).birthday) < 0;
						case "name":
							isGreater = result.get(j).name.compareTo(result.get(j+1).name) > 0;
					}
					if ( isGreater ) {
						result.add(j+2, result.get(j));
						result.remove(j);
						sorted = false;					
					}
				}

			} while (!sorted);

			return result;

		}
	*/


}




