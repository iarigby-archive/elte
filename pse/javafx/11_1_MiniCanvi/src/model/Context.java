package model;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Context {
	public static final EntityManager entityManager = Persistence
			.createEntityManagerFactory("concentrate_on_your_solution_as_much_as_you_can_-_fingers_crossed")
			.createEntityManager();
}
