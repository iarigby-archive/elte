package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.City;
import model.City_;
import model.Country;
import model.Country_;
import model.Language;
import model.Language_;

public class Grade3 {

    private static final EntityManager manager = GlobalEntityManager.getInstance().getEntityManager();

    public static void main(String[] args) {

        List<City> germanSpeakingCities = getCitiesOfLanguage("German");
        if (germanSpeakingCities.size() == 2 && germanSpeakingCities.contains(manager.find(City.class, "Buenos Aires"))
                && germanSpeakingCities.contains(manager.find(City.class, "München"))) {
            System.out.println("You probably passed grade 3. Check that your method contains at least 2 queries.");
        } else {
            System.err.println("Something is wrong in part \"Grade 3\"");
        }

    }

    private static List<City> getCitiesOfLanguage(String languageName) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
    	CriteriaQuery<Language> lq = cb.createQuery(Language.class);
        Root<Language> language = lq.from(Language.class);
        lq.where(cb.equal(language.get(Language_.name), languageName));
        lq.select(language);
        Language selectedLanguage = manager.createQuery(lq).getSingleResult();
        CriteriaQuery<Country> cq = cb.createQuery(Country.class);
        Root<Country> country = cq.from(Country.class);
        cq.where(cb.isMember(selectedLanguage, country.get(Country_.languages)));
        cq.select(country);
        List<Country> resultList = manager.createQuery(cq).getResultList();
        CriteriaQuery<City> ciq = cb.createQuery(City.class);
        Root<City> city = ciq.from(City.class);
        ciq.where(cb.equal(city.get(City_.country).in(resultList), true));
        ciq.select(city);
        return manager.createQuery(ciq).getResultList();
    }

}
