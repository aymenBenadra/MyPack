package ma.youcode.mypack.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import ma.youcode.mypack.daos.ChaufeurDAO;
import ma.youcode.mypack.daos.ManagerDAO;
import ma.youcode.mypack.entities.ChaufeurEntity;
import ma.youcode.mypack.entities.ManagerEntity;
import ma.youcode.mypack.services.interfaces.IAdminService;

@RequestScoped
public class AdminService implements IAdminService {

    @Inject
    private ManagerDAO managerDAO;
    @Inject
    private ChaufeurDAO chaufeurDAO;

    @Override
    public boolean addManager(ManagerEntity manager) {
        try {
            managerDAO.create(manager);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeManager(Long id) {
        try {
            managerDAO.delete(managerDAO.find(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ManagerEntity getManager(Long id) {
        return (ManagerEntity) managerDAO.find(id);
    }

    @Override
    public boolean addChaufeur(ChaufeurEntity chaufeur) {
        try {
            chaufeurDAO.create(chaufeur);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeChaufeur(Long id) {
        try {
            chaufeurDAO.delete(chaufeurDAO.find(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ChaufeurEntity getChaufeur(Long id) {
        return (ChaufeurEntity) chaufeurDAO.find(id);
    }
}
