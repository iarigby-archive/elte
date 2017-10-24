package service;

import java.util.Date;
import java.text.*;
import java.util.ArrayList;

public class Baby {

	private String name;
	private Date birthday;
	private char gender;
	private static SimpleDateFormat myFormat = new SimpleDateFormat("ddMMyyyy HHmm");

	private static ArrayList<Gift> gifts = new ArrayList<Gift>();


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

	public static void printGifts(ArrayList<Gift> gifts) {
		for (Gift gift : gifts) System.our.println(gift);
	}

	@Override
	public String toString() {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String birthdate = format.format(this.birthday);

		return name + " " + birthdate;

	}

	public boolean equals(Baby baby) { return this.name.equals(baby.name) && this.birthday == baby.birthday && this.gender == baby.gender;}
	
	public static ArrayList<Gift> getGifts() {return gifts;}

	public static void addGift(String name, String description, String date) throws ParseException {
		
		Gift gift = new Gift(name, description, myFormat.parse(date));
		gifts.add(gift);
	
	}

	/*

	public static ArrayList<Baby> bubbleSort(ArrayList<Baby> babies, String type) {
			
			ArrayList<Baby> result = new ArrayList<Baby>(babies);
			
			boolean isGreater = false;
			boolean sorted;
			do {
				sorted = true;
				for (int j = 0; j < result.size()-1; j++) {
					switch (type) {
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




