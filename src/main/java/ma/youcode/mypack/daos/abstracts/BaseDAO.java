package ma.youcode.mypack.daos.abstracts;

import jakarta.persistence.EntityManager;
import ma.youcode.mypack.daos.interfaces.IBaseDAO;
import ma.youcode.mypack.helpers.PersistenceManager;

import java.util.List;

public abstract class BaseDAO<T> implements IBaseDAO<T> {

    protected final Class<T> entityClass;

    public BaseDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void create(T t) {
        EntityManager em = PersistenceManager.beginTransaction();
        try {
            em.persist(t);
            PersistenceManager.commitTransaction(em);
        } catch (Exception e) {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(em);
        }
    }

    @Override
    public void update(T t) {
        EntityManager em = PersistenceManager.beginTransaction();
        try {
            em.merge(t);
            PersistenceManager.commitTransaction(em);
        } catch (Exception e) {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(em);
        }
    }

    @Override
    public void delete(T t) {
        EntityManager em = PersistenceManager.beginTransaction();
        try {
            em.remove(t);
            PersistenceManager.commitTransaction(em);
        } catch (Exception e) {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(em);
        }
    }

    @Override
    public T find(Long id) {
        EntityManager em = PersistenceManager.beginTransaction();
        try {
            T t = em.find(entityClass, id);
            PersistenceManager.commitTransaction(em);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(em);
            return null;
        }
    }

    @Override
    public List<T> findAll() {
        EntityManager em = PersistenceManager.beginTransaction();
        try {
            List<T> list = em.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
            PersistenceManager.commitTransaction(em);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(em);
            return null;
        }
    }
}
