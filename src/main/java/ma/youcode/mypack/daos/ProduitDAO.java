package ma.youcode.mypack.daos;

import jakarta.persistence.EntityManager;
import ma.youcode.mypack.daos.abstracts.BaseDAO;
import ma.youcode.mypack.daos.interfaces.IProduitDAO;
import ma.youcode.mypack.entities.ProduitEntity;
import ma.youcode.mypack.helpers.PersistenceManager;

import java.util.List;

public class ProduitDAO extends BaseDAO<ProduitEntity> implements IProduitDAO {

    public ProduitDAO() {
        super(ProduitEntity.class);
    }

    @Override
    public ProduitEntity findByNom(String nom) {
        EntityManager em = PersistenceManager.beginTransaction();
        try {
            ProduitEntity produit = em.createQuery("SELECT p FROM Produit p WHERE p.nom = :nom", ProduitEntity.class)
                    .setParameter("nom", nom)
                    .getSingleResult();
            PersistenceManager.commitTransaction(em);
            return produit;
        } catch (Exception e) {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(em);
            return null;
        }
    }

    @Override
    public List<ProduitEntity> findByFragile(boolean fragile) {
        EntityManager em = PersistenceManager.beginTransaction();
        try {
            List<ProduitEntity> produits = em.createQuery("SELECT p FROM Produit p WHERE p.fragile = :fragile", ProduitEntity.class)
                    .setParameter("fragile", fragile)
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
