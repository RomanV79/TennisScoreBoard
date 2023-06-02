package dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T>{
    //create
    void add(T t);

    //read
    Optional<T> getById(int id);
    List<T> getAll();

}
