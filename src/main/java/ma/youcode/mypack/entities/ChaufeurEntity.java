package ma.youcode.mypack.entities;

import jakarta.persistence.*;
import ma.youcode.mypack.entities.abstracts.Person;
import ma.youcode.mypack.entities.enums.VehiculeTypes;

@Entity(name = "Chaufeur")
@Table(name = "chauffeur", schema = "mypack")
public class ChaufeurEntity extends Person {

    @Enumerated(EnumType.STRING)
    @Column(name = "type_vehicule")
    private VehiculeTypes vehiculeType;

    public VehiculeTypes getVehiculeType() {
        return vehiculeType;
    }

    public void setVehiculeType(VehiculeTypes vehiculeType) {
        this.vehiculeType = vehiculeType;
    }
}
