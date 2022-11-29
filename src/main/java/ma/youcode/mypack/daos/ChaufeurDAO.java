package ma.youcode.mypack.daos;

import jakarta.enterprise.context.RequestScoped;
import ma.youcode.mypack.daos.abstracts.PersonDAO;
import ma.youcode.mypack.entities.ChaufeurEntity;

import java.io.Serializable;

@RequestScoped
public class ChaufeurDAO extends PersonDAO<ChaufeurEntity> implements Serializable {
    public ChaufeurDAO() {
        super(ChaufeurEntity.class);
    }
}
