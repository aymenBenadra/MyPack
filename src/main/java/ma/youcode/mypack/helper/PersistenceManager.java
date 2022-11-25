package ma.youcode.mypack.helper;

import com.google.common.base.Preconditions;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;

public class PersistenceManager {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("mypack", loadProperties("mypack"));
        }
        return entityManagerFactory.createEntityManager();
    }

    private static HashMap<String, String> loadProperties(String persistenceUnitName) {
        Preconditions.checkNotNull(persistenceUnitName);
        Dotenv dotenv = Dotenv.load();
        HashMap<String, String> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.url", dotenv.get("DATABASE_URL"));
        properties.put("jakarta.persistence.jdbc.user", dotenv.get("DATABASE_USERNAME"));
        properties.put("jakarta.persistence.jdbc.password", dotenv.get("DATABASE_PASSWORD"));
        properties.put("jakarta.persistence.jdbc.driver", dotenv.get("DATABASE_DRIVER"));
        return properties;
    }

    public static EntityManager beginTransaction() {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        return entityManager;
    }

    public static void commitTransaction(EntityManager em) {
        em.getTransaction().commit();
    }

    public static void rollbackTransaction(EntityManager em) {
        em.getTransaction().rollback();
    }

    public static void close() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    public static void changePersistenceUnit(String persistenceUnit) {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
        entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit, loadProperties(persistenceUnit));
    }
}
