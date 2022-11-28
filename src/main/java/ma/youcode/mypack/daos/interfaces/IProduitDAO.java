package ma.youcode.mypack.daos.interfaces;

import ma.youcode.mypack.entities.ProduitEntity;

import java.util.List;

public interface IProduitDAO extends IBaseDAO<ProduitEntity> {
    List<ProduitEntity> findAllByClient(Long clientId);
}
