package ma.youcode.mypack.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import ma.youcode.mypack.daos.AdminDAO;
import ma.youcode.mypack.daos.ClientDAO;
import ma.youcode.mypack.daos.ManagerDAO;
import ma.youcode.mypack.entities.ClientEntity;
import ma.youcode.mypack.entities.abstracts.Person;
import ma.youcode.mypack.helpers.SessionManager;
import ma.youcode.mypack.services.interfaces.IAuthService;

import java.io.Serializable;

@RequestScoped
public class AuthService implements Serializable, IAuthService {

    @Inject
    private ClientDAO clientDAO;
    @Inject
    private AdminDAO adminDAO;
    @Inject
    private ManagerDAO managerDAO;

    @Override
    public boolean login(String email, String password, String role) {
        Person person = switch (role) {
            case "client" -> clientDAO.findByEmail(email);
            case "admin" -> adminDAO.findByEmail(email);
            case "manager" -> managerDAO.findByEmail(email);
            default -> null;
        };
        if (person != null && person.getPassword().equals(password)) {
            person.setPassword("");
            SessionManager.setAttribute("currentUser", person);
            return true;
        }

        return false;
    }

    @Override
    public boolean logout() {
        return SessionManager.removeAttribute("currentUser");
    }

    @Override
    public boolean register(ClientEntity client) {
        try {
            clientDAO.create(client);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isLoggedIn() {
        return SessionManager.getAttribute("currentUser") != null;
    }

    @Override
    public Person getCurrentUser() {
        return (Person) SessionManager.getAttribute("currentUser");
    }
}
