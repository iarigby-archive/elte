package main;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.Assignment;
import model.AssignmentSolution;
import model.AssignmentSolution_;
import model.Context;
import model.Student;
import model.Teacher;

public class Main {

	private static final EntityManager entityManager = Context.entityManager;

	public static void main(String[] args) throws Exception {

		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Budapest"));

		// Grade 2
		entityManager.getTransaction().begin();
		Teacher tamas = new Teacher("Tamás");
		Teacher rudolf = new Teacher("Rudolf");

		Student s1 = new Student("Student1");
		Student s2 = new Student("Student2");

		Assignment a = new Assignment("Persistence and Model implementation",
				new SimpleDateFormat("dd/MM/yyyy, HH:mm").parse("29/04/2018, 23:59"));

		entityManager.persist(tamas);
		entityManager.persist(rudolf);
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityManager.persist(a);
		entityManager.getTransaction().commit();
		
		s1.addOneMoreImpossibleAssignment(a);
		s2.addOneMoreImpossibleAssignment(a);
		entityManager.refresh(s1); // refreshes s1 object using the DB
		entityManager.refresh(s2);
		List<AssignmentSolution> solutions = getSubmittedSolutionsFor(a);
		System.out.println(allStudentsHave(a, s1, s2)); //del
		System.out.println(solutions.isEmpty()); //del
		if (allStudentsHave(a, s1, s2) && solutions.isEmpty()) {
			System.out.println("Grade 2 achieved, Grade 3: ready, steady, goo");
		} else {
			throw new Exception("Condition on grade 2 has not resulted the expected");
		}

		// 
		s1.solve(a);
		entityManager.refresh(s1);
		AssignmentSolution solution = null;
		try {
			solution = getSolutionOf(s1, a);
		} catch (Exception e) {
			throw new Exception("You forgot to store a new assignment solution for s1 or your query needs some improvement.");
		}
		if (!s1.getAssignments().contains(a) && !solution.isChecked()
				&& solution.getSubmissionDate().after(a.getDueDate())) {
			System.out.println("Grade 3 achieved, the remaining task will be easier, keep it up");
		} else {
			throw new Exception("Condition on grade 3 has not resulted the expected");
		}

		// Grade 4
		tamas.checkAll();
		entityManager.refresh(solution);
		if (solution.isChecked()) {
			System.out.println("Grade 4 achieved, make your code looking handsome and you are done");
		} else {
			throw new Exception("Condition on grade 4 has not resulted the expected");
		}

		// Grade 5
		// just clean your code, that makes you a useful and reliable programmer

	}

	private static boolean allStudentsHave(Assignment a, Student s1, Student s2) {
		System.out.println("checking"); //del
		System.out.println(s1.getAssignments().contains(a)); //del
		System.out.println(s2.getAssignments().contains(a));//del
		return s1.getAssignments().contains(a) && s2.getAssignments().contains(a);
	}

	private static List<AssignmentSolution> getSubmittedSolutionsFor(Assignment a) {
	    // write this query to return all ASolutions that are related to 'a'.
		return a.getSolutions();
	}

	private static AssignmentSolution getSolutionOf(Student s1, Assignment a) {
	    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AssignmentSolution> solutionQuery = cb.createQuery(AssignmentSolution.class);
        Root<AssignmentSolution> root = solutionQuery.from(AssignmentSolution.class);
        solutionQuery.where(cb.and(
                cb.equal(root.get(AssignmentSolution_.student), s1),
                cb.equal(root.get(AssignmentSolution_.assignment), a))
        );
		return entityManager.createQuery(solutionQuery).getSingleResult();
	}

}
