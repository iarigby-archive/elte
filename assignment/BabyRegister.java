import service.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
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
			babies.add(new Date(), "six", 'm');	

			Baby.addGift("someone", "something");
			Baby.addGift("someone else", "something else", "15102017 1400");
			Baby.addGift(new Gift("person", "gift1", new Date()));

		} catch (ParseException e) {
			System.out.print(e);
		}


		String welcometext = "\n\n enter number for your choice (Type 'exit' to quit) \n 1. Add a new Baby \n 2. List Babies by age (ascending) \n 3. List Babies by name \n 4. Add gift \n 5. List gifts: ";
		Scanner in = new Scanner(System.in);
		String input;
		boolean repeat;
		
		System.out.println("Hello!");

		do {

			System.out.print(welcometext);
			input = in.nextLine();
			switch (input) {

				case "1":

					System.out.print("Enter Baby's name: ");
					String name = in.nextLine();
					
					char gender;
					do {
						System.out.print("Enter Baby's gender (f or m): ");
						gender = in.nextLine().charAt(0);
					}	while (!(gender == 'f' || gender == 'm'));
					
					System.out.print("Enter Baby's birthdate: ");
					
					repeat = true;
					while (repeat) {
						try {
							String birthdate = in.nextLine();
							Baby baby = new Baby(birthdate, name, gender);
							babies.add(baby);
							repeat = false;
							System.out.println("Baby added successfully");
						} catch (ParseException e) {
							System.err.print("\tPlease enter date in following format - ddMMyyyy HHmm: ");
							repeat = true;
						}
					}

					break;

				case "2":

					Baby.printAll(Baby.listByAge(babies));
					break;

				case "3":

					Baby.printAll(Baby.listByName(babies));
					break;

				case "4":

					System.out.print("Enter giver's name: ");
					String giftName = in.nextLine();
					System.out.print("Enter gift's description: ");
					String description = in.nextLine();
					
					repeat = true;
					System.out.print("Enter Date when it was given: ");
					while (repeat) {	
						String giftDate = in.nextLine();
						try {
							Baby.addGift(giftName, description, giftDate);
							repeat = false;
							System.out.println("Gift added successfully");
						}
						catch (ParseException e) {
							System.err.print("\tPlease enter date in following format - ddMMyyyy HHmm: ");
							repeat = true;
						}
					}
					break;

				case "5":

					Baby.printGifts();
					break;	
			}

		} while (!input.equals("exit"));	
	
	}

}