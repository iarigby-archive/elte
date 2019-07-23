package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Enumerated(EnumType.STRING)
	private Day day;

	private String soup;

	private String mainCourse;

	private String dessert;

	private int price;

	public Menu() {
	}

	public Menu(Day day, String soup, String mainCourse, String dessert, int price) {
		this.day = day;
		this.soup = soup;
		this.mainCourse = mainCourse;
		this.dessert = dessert;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public Day getDay() {
		return day;
	}

	public String getSoup() {
		return soup;
	}

	public String getMainCourse() {
		return mainCourse;
	}

	public String getDessert() {
		return dessert;
	}

	public int getPrice() {
		return price;
	}
}
