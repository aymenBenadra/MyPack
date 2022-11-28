package ma.youcode.mypack.services.interfaces;

import ma.youcode.mypack.entities.ProduitEntity;
import ma.youcode.mypack.entities.TransactionEntity;

import java.util.List;

public interface IClientService {
    boolean addProduit(ProduitEntity produit, TransactionEntity transaction);
    boolean removeProduit(Long id);
    boolean updateProduit(ProduitEntity produit);
    ProduitEntity getProduit(Long id);
    List<ProduitEntity> getProduits();
}
