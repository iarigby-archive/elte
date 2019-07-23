package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import model.Customer_;
import model.Day;
import model.Menu;
import model.Menu_;
import model.Orders;
import model.Orders_;

public class Main {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("cantine");
		EntityManager entityManager = emfactory.createEntityManager();
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		// what cookies does this cantine have?
		CriteriaQuery<String> cookieQuery = builder.createQuery(String.class);
		Root<Menu> menu = cookieQuery.from(Menu.class);
		Path<String> dessertName = menu.get(Menu_.dessert);
		cookieQuery.select(dessertName);
		cookieQuery.distinct(true);
		cookieQuery.orderBy(builder.asc(dessertName));
		List<String> cookieResult = entityManager.createQuery(cookieQuery).getResultList();
		System.out.println("Cookies:");
		cookieResult.forEach(System.out::println);
		
		// how many customers had it per day?
		CriteriaQuery<Tuple> customersQuery = builder.createTupleQuery();
		Root<Orders> order = customersQuery.from(Orders.class);
		Path<Day> day = order.get(Orders_.menu).get(Menu_.day);
		customersQuery.multiselect(day, builder.count(order.get(Orders_.customer)));
		customersQuery.groupBy(day);
		List<Tuple> customersResult = entityManager.createQuery(customersQuery).getResultList();
		System.out.println("Customers:");
		customersResult.forEach(t -> System.out.println("Day: " + t.get(0) + ", Count of people: " + t.get(1)));
		
		// who are the top 3 customers here (who visit us the most)? Sort them by visit count descending.
		CriteriaQuery<Tuple> top3Query = builder.createTupleQuery();
		order = top3Query.from(Orders.class);
		top3Query.groupBy(order.get(Orders_.customer));
		Expression<Long> orderCount = builder.count(order);
		top3Query.multiselect(order.get(Orders_.customer).get(Customer_.name), orderCount);
		top3Query.orderBy(builder.desc(orderCount));
		List<Tuple> top3Results = entityManager.createQuery(top3Query).setMaxResults(3).getResultList();
		System.out.println("Top 3:");
		top3Results.forEach(t -> System.out.println("Name: " + t.get(0) + ", How many times visited: " + t.get(1)));
		
		entityManager.close();
		emfactory.close();
		
	}

}
