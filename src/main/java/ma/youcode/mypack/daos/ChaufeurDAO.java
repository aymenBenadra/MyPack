package ma.youcode.mypack.daos;

import jakarta.persistence.EntityManager;
import ma.youcode.mypack.daos.abstracts.PersonDAO;
import ma.youcode.mypack.daos.interfaces.IChaufeurDAO;
import ma.youcode.mypack.entities.ChaufeurEntity;
import ma.youcode.mypack.entities.enums.VehiculeTypes;
import ma.youcode.mypack.helpers.PersistenceManager;

public class ChaufeurDAO extends PersonDAO<ChaufeurEntity> implements IChaufeurDAO {
    public ChaufeurDAO() {
        super(ChaufeurEntity.class);
    }

    @Override
    public ChaufeurEntity findByVehiculeType(VehiculeTypes vehiculeType) {
        EntityManager em = PersistenceManager.beginTransaction();
        try {
            ChaufeurEntity chaufeur = em.createQuery("SELECT c FROM Chaufeur c WHERE c.vehiculeType = :vehiculeType", ChaufeurEntity.class)
                    .setParameter("vehiculeType", vehiculeType)
                    .getSingleResult();
            PersistenceManager.commitTransaction(em);
            return chaufeur;
        } catch (Exception e) {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(em);
            return null;
        }
    }
}
