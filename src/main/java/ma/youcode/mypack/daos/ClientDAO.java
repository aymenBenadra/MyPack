package ma.youcode.mypack.daos;

import ma.youcode.mypack.daos.abstracts.PersonDAO;
import ma.youcode.mypack.entities.ClientEntity;

public class ClientDAO extends PersonDAO<ClientEntity> {

    public ClientDAO() {
        super(ClientEntity.class);
    }
}
