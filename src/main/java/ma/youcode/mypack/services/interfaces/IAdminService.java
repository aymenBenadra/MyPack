package ma.youcode.mypack.services.interfaces;

import ma.youcode.mypack.entities.ChaufeurEntity;
import ma.youcode.mypack.entities.ManagerEntity;

public interface IAdminService {
    boolean addManager(ManagerEntity manager);
    boolean removeManager(Long id);
    ManagerEntity getManager(Long id);
    boolean addChaufeur(ChaufeurEntity chaufeur);
    boolean removeChaufeur(Long id);
    ChaufeurEntity getChaufeur(Long id);
}
