package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.NoSuchUserException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.User;
import at.ac.campuswien.fh.foodsy.foodsy_backend.repository.UserDao;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUUID(String userUUID){
        Optional<User> user = userDao.getUUID(userUUID);
        if(user.isPresent()){
            return  user.get();
        }else{
            throw new NoSuchUserException("No User with this UUID");
        }
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
        throw new NotYetImplementedException();
    }
    @Override
    public void deleteUser(User user){
        userDao.delete(user);
    }

}
