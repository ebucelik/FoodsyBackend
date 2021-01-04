package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> getUUID(String uuid);

    String getUUID(String username, String password);

    User save(User user);

    User update(User updated);

    void delete(User user);
}
