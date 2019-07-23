package main;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Customer;
import model.Day;
import model.Menu;
import model.Orders;

public class DatabaseFiller {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("cantine");
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();

		Menu menu1 = new Menu(Day.MONDAY, "soup1", "main1", "cookie1", 890);
		Menu menu2 = new Menu(Day.TUESDAY, "soup2", "main2", "cookie1", 990);
		Menu menu3 = new Menu(Day.WEDNESDAY, "soup3", "main2", "cookie2", 990);
		Menu menu4 = new Menu(Day.THURSDAY, "soup4", "main3", "cookie2", 1090);
		Menu menu5 = new Menu(Day.FRIDAY, "soup5", "main4", "cookie3", 990);
		Menu menu6 = new Menu(Day.SATURDAY, "soup6", "main4", "cookie3", 890);
		entityManager.persist(menu1);
		entityManager.persist(menu2);
		entityManager.persist(menu3);
		entityManager.persist(menu4);
		entityManager.persist(menu5);
		entityManager.persist(menu6);

		Customer customer1 = new Customer("Tamas");
		Customer customer2 = new Customer("Zsofi");
		Customer customer3 = new Customer("Istvan");
		Customer customer4 = new Customer("Rudolf");
		Customer customer5 = new Customer("Tibor");
		Customer customer6 = new Customer("Zsolt");
		entityManager.persist(customer1);
		entityManager.persist(customer2);
		entityManager.persist(customer3);
		entityManager.persist(customer4);
		entityManager.persist(customer5);
		entityManager.persist(customer6);

		entityManager.persist(new Orders(customer1, menu1, date("2018-03-19", "11:15:30")));
		entityManager.persist(new Orders(customer2, menu1, date("2018-03-19", "11:20:30")));
		entityManager.persist(new Orders(customer4, menu1, date("2018-03-19", "11:22:30")));
		entityManager.persist(new Orders(customer6, menu1, date("2018-03-19", "11:45:30")));

		entityManager.persist(new Orders(customer1, menu2, date("2018-03-20", "11:15:00")));
		entityManager.persist(new Orders(customer3, menu2, date("2018-03-20", "11:35:00")));
		entityManager.persist(new Orders(customer4, menu2, date("2018-03-20", "11:39:00")));
		entityManager.persist(new Orders(customer5, menu2, date("2018-03-20", "11:55:00")));

		entityManager.persist(new Orders(customer1, menu3, date("2018-03-21", "11:15:00")));
		entityManager.persist(new Orders(customer4, menu3, date("2018-03-21", "11:45:00")));
		entityManager.persist(new Orders(customer6, menu3, date("2018-03-21", "11:50:00")));

		entityManager.persist(new Orders(customer1, menu4, date("2018-03-22", "11:15:00")));

		entityManager.persist(new Orders(customer2, menu5, date("2018-03-23", "11:25:00")));
		entityManager.persist(new Orders(customer3, menu5, date("2018-03-23", "11:45:00")));
		entityManager.persist(new Orders(customer5, menu5, date("2018-03-23", "11:55:00")));

		entityManager.getTransaction().commit();
		entityManager.close();
		emfactory.close();
	}

	private static Date date(String day, String clock) {
		return Date.from(Instant.parse(day + "T" + clock + ".00Z").atZone(ZoneId.systemDefault()).toInstant());
	}
}
