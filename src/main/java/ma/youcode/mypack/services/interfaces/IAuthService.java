package ma.youcode.mypack.services.interfaces;

import ma.youcode.mypack.entities.ClientEntity;
import ma.youcode.mypack.entities.abstracts.Person;

public interface IAuthService {
    boolean login(String email, String password, String role);
    boolean logout();
    boolean register(ClientEntity client);
    boolean isLoggedIn();
    Person getCurrentUser();
}
