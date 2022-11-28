package ma.youcode.mypack.entities;

import jakarta.persistence.*;
import ma.youcode.mypack.entities.abstracts.Person;

import java.util.Collection;

@Entity(name = "Client")
@Table(name = "client", schema = "mypack")
public class ClientEntity extends Person {
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Collection<ProduitEntity> produits;

    public Collection<ProduitEntity> getProduits() {
        return produits;
    }

    public void setProduits(Collection<ProduitEntity> produits) {
        this.produits = produits;
    }
}
