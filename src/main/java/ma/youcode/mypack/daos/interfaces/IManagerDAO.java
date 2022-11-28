package ma.youcode.mypack.daos.interfaces;

import ma.youcode.mypack.entities.ManagerEntity;

public interface IManagerDAO {
    ManagerEntity findByVille(String ville);
}
