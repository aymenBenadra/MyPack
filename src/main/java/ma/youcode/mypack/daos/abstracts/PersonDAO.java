package ma.youcode.mypack.daos.abstracts;

import jakarta.persistence.EntityManager;
import ma.youcode.mypack.daos.interfaces.IPersonDAO;
import ma.youcode.mypack.entities.abstracts.Person;
import ma.youcode.mypack.helpers.PersistenceManager;

public abstract class PersonDAO<T extends Person> extends BaseDAO<Person> implements IPersonDAO<Person> {

    public PersonDAO(Class<T> entityClass) {
        super((Class<Person>) entityClass);
    }
    
    @Override
    public Person findByEmail(String email) {
        EntityManager em = PersistenceManager.beginTransaction();
        try {
            Person person = em.createQuery("SELECT p FROM " + entityClass.getSimpleName() + " p WHERE p.email = :email", Person.class)
                    .setParameter("email", email)
                    .getSingleResult();
            PersistenceManager.commitTransaction(em);
            return person;
        } catch (Exception e) {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(em);
            return null;
        }
    }
}
