package ma.youcode.mypack.daos;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import ma.youcode.mypack.daos.abstracts.PersonDAO;
import ma.youcode.mypack.daos.interfaces.IManagerDAO;
import ma.youcode.mypack.entities.ManagerEntity;
import ma.youcode.mypack.helpers.PersistenceManager;

import java.io.Serializable;

@RequestScoped
public class ManagerDAO extends PersonDAO<ManagerEntity> implements IManagerDAO, Serializable {
    public ManagerDAO() {
        super(ManagerEntity.class);
    }

    @Override
    public ManagerEntity findByVille(String ville) {
        EntityManager em = PersistenceManager.getEntityManager();
        try {
            return em.createQuery("SELECT m FROM Manager m WHERE m.ville = :ville", ManagerEntity.class)
                    .setParameter("ville", ville)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
