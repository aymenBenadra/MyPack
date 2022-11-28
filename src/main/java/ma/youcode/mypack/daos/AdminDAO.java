package ma.youcode.mypack.daos;

import ma.youcode.mypack.daos.abstracts.PersonDAO;
import ma.youcode.mypack.entities.AdminEntity;

public class AdminDAO extends PersonDAO<AdminEntity> {
    public AdminDAO() {
        super(AdminEntity.class);
    }
}
