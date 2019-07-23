package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.City;
import model.City_;
import model.Continent;
import model.Country;
import model.Country_;
import model.Language;

public class Grade2 {

    private static final EntityManager manager = GlobalEntityManager.getInstance().getEntityManager();

    public static void main(String[] args) {

        manager.getTransaction().begin();

        try {
            Language l1 = new Language("English");
            Language l2 = new Language("Spanish");
            Language l3 = new Language("German");
            Language l4 = new Language("Hungarian");

            City c1 = new City("Budapest", 1_752_704);
            City c2 = new City("Buenos Aires", 2_890_151);
            City c3 = new City("München", 1_464_301);

            Country co1 = new Country("Argentina", Continent.SOUTH_AMERICA, new HashSet<>(Arrays.asList(l2, l1, l3)));
            Country co2 = new Country("Germany", Continent.EUROPE, new HashSet<>(Arrays.asList(l3)));
            Country co3 = new Country("Hungary", Continent.EUROPE, new HashSet<>(Arrays.asList(l4)));

            c1.setCountry(co3);
            c2.setCountry(co1);
            c3.setCountry(co2);

            manager.persist(c1);
            manager.persist(c2);
            manager.persist(c3);

            manager.getTransaction().commit();

            City budapest = getTheFirstCityOf("Hungary");
            if (budapest.getPopulation() == 1_752_704) {
                System.out.println("You probably passed grade 2. Check your database whether it's filled up correctly.");
            } else {
                System.err.println("Something is wrong in part \"Grade 2\"");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Something is wrong in part \"Grade 2\"");
            manager.getTransaction().rollback();
        }

    }

    private static City getTheFirstCityOf(String countryName) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<City> cq = cb.createQuery(City.class);
        Root<City> city = cq.from(City.class);
        cq.where(
        		cb.equal(city.get(City_.country).get(Country_.name), countryName));
        cq.select(city);
        List<City> resultList = manager.createQuery(cq).getResultList();
        return resultList.isEmpty() ?  null : resultList.get(0);
    }

}
