package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.User;
import at.ac.campuswien.fh.foodsy.foodsy_backend.repository.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDaoImpl userDao;

    @Override
    public User getUserByUUID(String userUUID){
        return userDao.getUUID(userUUID);
    }

    @Override
    public String loginByCredentials(String username, String password){
        return userDao.getUUID(username,password);
    }

    @Override
    public User saveUser(User user){
        return userDao.save(user);
    }

    @Override
    public User updateUser(User user){
        return userDao.update(user);
    }
    @Override
    public void deleteUser(User user){
        userDao.delete(user);
    }

}
