package ma.youcode.mypack.daos;

import jakarta.enterprise.context.RequestScoped;
import ma.youcode.mypack.daos.abstracts.PersonDAO;
import ma.youcode.mypack.entities.ClientEntity;

@RequestScoped
public class ClientDAO extends PersonDAO<ClientEntity> {
    public ClientDAO() {
        super(ClientEntity.class);
    }
}
