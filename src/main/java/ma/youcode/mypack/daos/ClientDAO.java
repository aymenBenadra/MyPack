package ma.youcode.mypack.daos;

import jakarta.enterprise.context.RequestScoped;
import ma.youcode.mypack.daos.abstracts.PersonDAO;
import ma.youcode.mypack.entities.ClientEntity;

import java.io.Serializable;

@RequestScoped
public class ClientDAO extends PersonDAO<ClientEntity> implements Serializable {
    public ClientDAO() {
        super(ClientEntity.class);
    }
}
