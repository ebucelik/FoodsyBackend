package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.User;

public interface UserService {
    User getUserByUUID(String userUUID);

    String loginByCredentials(String username, String password);

    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(User user);
}
