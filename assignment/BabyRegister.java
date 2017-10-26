import service.*;
import java.util.*;
import java.text.*;



public class BabyRegister {
	public static void main(String[] args) {
		ArrayList<Baby> babies = new ArrayList<Baby>();
		
		
		try {

			babies.add(new Baby("05102016 1330", "one", 'f'));
			babies.add(new Baby("05102016 1330", "two", 'm'));		
			babies.add(new Baby("05102017 1330", "three", 'm'));
			babies.add(new Baby("05102017 1331", "four", 'm'));				
			babies.add(new Baby("06102017 1330", "five", 'm'));	
			babies.add(new Baby(new Date(), "six", 'm'));	

			babies.get(1).addGift("someone", "something");
			babies.get(5).addGift("someone else", "something else", "15102017 1400");
			babies.get(5).addGift(new Gift("person", "gift1", new Date()));

		} catch (ParseException e) {
			System.out.print(e);
		}


		String welcometext = "\n\n 1. Add a new Baby \n 2. List Babies by age (ascending) \n 3. List Babies by name \n 4. Add gift \n 5. List gifts \n Enter number for your choice (Type 'exit' to quit): ";
		Scanner in = new Scanner(System.in);
		String input;
		boolean repeat;
		
		System.out.println("Hello!");

		do {

			System.out.print(welcometext);
			input = in.nextLine();
			switch (input) {

				case "1":
					newBaby(in, babies);
					break;

				case "2":
					Baby.printAll(Baby.listByAge(babies));
					break;

				case "3":
					Baby.printAll(Baby.listByName(babies));
					break;

				case "4":
					newGift(in, babies);		
					break;

				case "5":
					for (Baby baby : babies) baby.printGifts();
					break;	
				
			}

		} while (!input.equals("exit"));	
	
	}



   	//
	//

	public static void newBaby(Scanner in, ArrayList<Baby> babies) {

		System.out.print("Enter Baby's name: ");
		String name = in.nextLine();
		
		char gender;
		do {
			System.out.print("Enter Baby's gender (f or m): ");
			gender = in.nextLine().charAt(0);
		}	while (!(gender == 'f' || gender == 'm'));
		
		System.out.print("Enter Baby's birthdate (or type 'now'): ");
		
		Date date;
		String birthdate = in.nextLine();	
		if (birthdate.equals("now")) {
			date = new Date();
		} else {					
			date = valiDate(in, Baby.getDateFormat(), birthdate);
		}

		babies.add(new Baby(date, name, gender));
		System.out.println("Baby added successfully");
	
	}

	public static void newGift(Scanner in, ArrayList<Baby> babies) {

		System.out.println("Choose reciever from the list (enter number) ");
		for (int i = 0; i < babies.size(); i++) System.out.println("\t" + (i+1) + ". " + babies.get(i));
		
		int n = 0;
		do {
			try {
				n = Integer.parseInt(in.nextLine());	
			} catch (Exception e) {
				System.out.print("Please enter a number printed on screen: ");
			}	
		} while (n < 1 || n > babies.size());

		System.out.print("Enter giver's name: ");
		String giftName = in.nextLine();
		System.out.print("Enter gift's description: ");
		String description = in.nextLine();
		
		System.out.print("Enter Date when it was given (or type 'now'): ");
		Date date;
		String giftDate = in.nextLine();
		if (giftDate.equals("now")) {
			date = new Date();
		} else {
			date = valiDate(in, Baby.getDateFormat(), giftDate);
		}
		
		babies.get(n-1).addGift(giftName, description, date);
		System.out.println("Gift added successfully");
	}

	//pun intended
	public static Date valiDate(Scanner in, SimpleDateFormat myFormat, String giftDate) {
		Date date = new Date();
		boolean repeat = true;
		while (repeat) {	
			try {
				date = myFormat.parse(giftDate);
				repeat = false;
			}
			catch (ParseException e) {
				System.err.print("\tPlease enter date in following format - ddMMyyyy HHmm: ");
				repeat = true;
				giftDate = in.nextLine();
			}
		}
		return date;
	}

}