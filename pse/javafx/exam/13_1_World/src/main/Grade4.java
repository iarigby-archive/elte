package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import model.City;
import model.City_;

public class Grade4 {

    private static final EntityManager manager = GlobalEntityManager.getInstance().getEntityManager();

    public static void main(String[] args) {

        manager.getTransaction().begin();
        deleteCityWithMaximumPopulation();
        manager.getTransaction().commit();

        // This is a so-called JPQL query. Much easier to read/write, not type-safe in
        // return though.
        List<City> allcities = manager.createQuery("SELECT c FROM City c", City.class).getResultList();
        if (allcities.size() == 2 && allcities.contains(manager.find(City.class, "Budapest"))
                && allcities.contains(manager.find(City.class, "München"))) {
            System.out.println("You probably passed grade 4. Check the database whether the appropriate city has been deleted.");
        } else {
            System.err.println("Something is wrong in part \"Grade 4\"");
        }
    }

    private static void deleteCityWithMaximumPopulation() {
        // write this
    	CriteriaBuilder cb = manager.getCriteriaBuilder();
    	CriteriaQuery<City> cq = cb.createQuery(City.class);
    	Subquery<Integer> sq = cq.subquery(Integer.class);
    	Root<City> c1 = cq.from(City.class);
    	Root<City> c2 = sq.from(City.class);
    	sq.select(cb.greatest(c2.get(City_.population)));
    	cq.where(cb.equal(c1.get(City_.population), sq));
    	List<City> result = manager.createQuery(cq).getResultList();
    	
    	CriteriaDelete<City> cd = cb.createCriteriaDelete(City.class);
        Root<City> root = cd.from(City.class);
        manager.createQuery(cd.where(cb.equal(root.in(result), true)))
                .executeUpdate();
    }

}
