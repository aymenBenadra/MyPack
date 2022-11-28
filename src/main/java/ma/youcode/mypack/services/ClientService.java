package ma.youcode.mypack.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import ma.youcode.mypack.daos.interfaces.IProduitDAO;
import ma.youcode.mypack.daos.interfaces.ITransactionDAO;
import ma.youcode.mypack.entities.ProduitEntity;
import ma.youcode.mypack.entities.TransactionEntity;
import ma.youcode.mypack.services.interfaces.IAuthService;
import ma.youcode.mypack.services.interfaces.IClientService;

import java.util.List;

@RequestScoped
public class ClientService implements IClientService {

    @Inject
    private IProduitDAO produitDAO;
    @Inject
    private ITransactionDAO transactionDAO;
    @Inject
    private IAuthService authService;

    @Override
    public boolean addProduit(ProduitEntity produit, TransactionEntity transaction) {
        try {
            produitDAO.create(produit);
            transaction.setProduit(produit);
            transactionDAO.create(transaction);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeProduit(Long id) {
        try {
            produitDAO.delete(produitDAO.find(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProduit(ProduitEntity produit) {
        try {
            produitDAO.update(produit);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ProduitEntity getProduit(Long id) {
        try {
            return produitDAO.find(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ProduitEntity> getProduits() {
        try {
            return produitDAO.findAllByClient(authService.getCurrentUser().getId());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
