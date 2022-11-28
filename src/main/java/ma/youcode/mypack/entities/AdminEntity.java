package ma.youcode.mypack.entities;

import jakarta.persistence.*;
import ma.youcode.mypack.entities.abstracts.Person;

@Entity(name = "Admin")
@Table(name = "admin", schema = "mypack")
public class AdminEntity extends Person {}
