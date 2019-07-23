package main;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class GlobalEntityManager {

    private static GlobalEntityManager instance = null;
    private final EntityManager entityManager;

    private GlobalEntityManager() {
        entityManager = Persistence.createEntityManagerFactory("World_PU").createEntityManager();
    }

    public static GlobalEntityManager getInstance() {
        if (instance == null) {
            instance = new GlobalEntityManager();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
