package ma.youcode.mypack.daos;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import ma.youcode.mypack.daos.abstracts.BaseDAO;
import ma.youcode.mypack.daos.interfaces.IProduitDAO;
import ma.youcode.mypack.entities.ProduitEntity;
import ma.youcode.mypack.helpers.PersistenceManager;

import java.util.List;

@RequestScoped
public class ProduitDAO extends BaseDAO<ProduitEntity> implements IProduitDAO {

    public ProduitDAO() {
        super(ProduitEntity.class);
    }

    @Override
    public List<ProduitEntity> findAllByClient(Long clientId) {
        EntityManager em = PersistenceManager.beginTransaction();
        try {
            List<ProduitEntity> produits = em.createQuery("SELECT p FROM Produit p WHERE p.client.id = :clientId", ProduitEntity.class)
                    .setParameter("clientId", clientId)
                    .getResultList();
            PersistenceManager.commitTransaction(em);
            return produits;
        } catch (Exception e) {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(em);
            return null;
        }
    }
}
