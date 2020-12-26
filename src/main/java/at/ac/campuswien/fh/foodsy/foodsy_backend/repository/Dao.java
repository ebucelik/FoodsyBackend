package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    T get(long id);

    T save(T t);

    T update(T t);

    void delete(T t);
}
