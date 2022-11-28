package ma.youcode.mypack.daos.interfaces;

import java.util.List;

public interface IBaseDAO<T> {
    void create(T t);
    void update(T t);
    void delete(T t);
    T find(Long id);
    List<T> findAll();
}
