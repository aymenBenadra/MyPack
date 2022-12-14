package ma.youcode.mypack.daos;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import ma.youcode.mypack.daos.abstracts.BaseDAO;
import ma.youcode.mypack.daos.interfaces.ITransactionDAO;
import ma.youcode.mypack.entities.TransactionEntity;
import ma.youcode.mypack.helpers.PersistenceManager;

import java.io.Serializable;
import java.util.List;

@RequestScoped
public class TransactionDAO extends BaseDAO<TransactionEntity> implements ITransactionDAO, Serializable {
    public TransactionDAO() {
        super(TransactionEntity.class);
    }

    @Override
    public List<TransactionEntity> findByVille(String ville) {
        EntityManager em = PersistenceManager.beginTransaction();
        try {
            List<TransactionEntity> transactions = em.createQuery("SELECT t FROM Transaction t WHERE t.villeActuelle = :ville", TransactionEntity.class)
                    .setParameter("ville", ville)
                    .getResultList();
            PersistenceManager.commitTransaction(em);
            return transactions;
        } catch (Exception e) {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(em);
            return null;
        }
    }
}
