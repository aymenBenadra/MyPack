package ma.youcode.mypack.entities;

import jakarta.persistence.*;
import ma.youcode.mypack.entities.abstracts.Person;

@Entity(name = "Manager")
@Table(name = "manager", schema = "mypack")
public class ManagerEntity extends Person {
    private String ville;

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
