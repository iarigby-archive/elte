package main;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.Admin;
import model.Writer;
import model.Note;
import model.User_;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Chat_PU");
        EntityManager entityManager = emfactory.createEntityManager();


        // --------------- PART 1 ---------------
        // Implement 3 classes in the model: User, Customer and Admin with
        // proper inheritance and the 'authenticate(String, char[])' method from Authentication.java
        AuthenticationManager auth = new AuthenticationManager(entityManager);

        entityManager.getTransaction().begin();
        Writer tamas = auth.registerWriter("Tamas", "1234".toCharArray());
        entityManager.persist(tamas);

        Admin istvan = auth.registerAdmin("Istvan", "asdf".toCharArray());
        entityManager.persist(istvan);

        entityManager.getTransaction().commit();

        if (auth.authenticate("Istvan", "asdf".toCharArray()) &&
                !auth.authenticate("Istvan", "456".toCharArray()) &&
                auth.authenticate("Tamas", "1234".toCharArray()) &&
                !auth.authenticate("Tamas", "hadf".toCharArray())) {
            System.out.println("Congrats! You passed PART 1!");
        } else {
            throw new IllegalStateException("PART 1 is failed.");
        }





        // --------------- PART 2 ---------------
        entityManager.getTransaction().begin();
        Note n1 = new Note();
        tamas.addNote(n1);
        entityManager.getTransaction().commit();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Writer> writerQuery = cb.createQuery(Writer.class);
		Root<Writer> writer = writerQuery.from(Writer.class);
		writerQuery.where(cb.equal(writer.get(User_.name), "Tamas"));
		writerQuery.select(writer);
		List<Writer> writers = entityManager.createQuery(writerQuery).getResultList();

        if (writers.size() == 1 &&
                writers.get(0).getNotes().size() == 1 &&
                writers.get(0).getNotes().iterator().next().getId() == n1.getId()) {
            System.out.println("Congrats! You passed PART 2!");
        } else {
            System.out.println("writers.size():" + writers.size());
            System.out.println("writers.get(0).getNotes().size(): " +
                    writers.get(0).getNotes().size());
            System.out.println("writers.get(0).getNotes().iterator().next().getId(): " +
                    writers.get(0).getNotes().iterator().next().getId());
            throw new IllegalStateException("PART 2 is failed.");
        }





        // --------------- PART 3 ---------------
        entityManager.getTransaction().begin();
        Note[] additionalNotes = new Note[5];
        for (int i = 0; i < 5; i++) {
            additionalNotes[i] = new Note();
            tamas.addNote(additionalNotes[i]);
        }
        entityManager.getTransaction().commit();

        Set<Integer> ids = tamas.getNotes().stream().map(Note::getId).collect(Collectors.toSet());
        for (int i = 0; i < 4; i++) {
            if (!ids.contains(additionalNotes[i].getId())) {
                System.out.println("ids:" + ids + " should contain " + additionalNotes[i].getId());
                throw new IllegalStateException("PART 3 is failed.");
            }
        }
        if (!ids.contains(additionalNotes[4].getId()) && ids.contains(n1.getId())) {
            System.out.println("Congrats! You passed PART 3!");
        } else {
            System.out.println("ids:" + ids + " should not contain " + additionalNotes[4].getId());
            System.out.println("ids:" + ids + " should contain " + n1.getId());
            throw new IllegalStateException("PART 3 is failed.");
        }





        // --------------- PART 4 ---------------
        // Admins can remove Customers. In this case the customer still stays in the database
        // but won't be able to log in anymore.
        entityManager.getTransaction().begin();
        tamas.setBlockedBy(istvan);
        entityManager.getTransaction().commit();

		if (tamas.isBlocked() && !auth.authenticate("Tamas", "1234".toCharArray())) {
			System.out.println("Congrats! You passed ALL PARTS!");
		} else {
			System.out.println("tamas.isRemoved(): " + tamas.isBlocked());
			System.out.println("auth.authenticate(\"Tamas\", \"1234\".toCharArray()): " + auth.authenticate("Tamas", "1234".toCharArray()));
			throw new IllegalStateException("PART 4 is failed.");
		}
    }
}
