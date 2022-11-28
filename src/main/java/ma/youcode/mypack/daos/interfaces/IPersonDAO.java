package ma.youcode.mypack.daos.interfaces;

import ma.youcode.mypack.entities.abstracts.Person;

public interface IPersonDAO<T extends Person> extends IBaseDAO<T> {
    T findByEmail(String email);
}
