package ma.youcode.mypack.daos;

import jakarta.enterprise.context.RequestScoped;
import ma.youcode.mypack.daos.abstracts.PersonDAO;
import ma.youcode.mypack.entities.AdminEntity;

@RequestScoped
public class AdminDAO extends PersonDAO<AdminEntity> {
    public AdminDAO() {
        super(AdminEntity.class);
    }
}
