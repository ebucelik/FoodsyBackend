package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import java.util.UUID;
import javax.persistence.NoResultException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.NoSuchUserException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.UserCredentialsNotAuthorizedException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.UserUpdateNotPossibleException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.UsernameAlreadyExistsException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements Dao<User> {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    static Session sessionObj;
    private static final String READ_BY_UUID = "SELECT u FROM User u WHERE u.userUUID = ?0";
    private static final String READ_BY_USERNAME_PW = "SELECT u FROM User u WHERE u.username = ?0 AND u.password =?1";
    private static final String READ_BY_USERNAME = "SELECT u FROM User u WHERE u.username = ?0";
    private static final String READ_BY_ID = "SELECT u FROM User u WHERE u.id = ?0";

    public User getUUID(String uuid) {
        try {
            sessionObj = sessionFactory.openSession();
            Query<User> getUserByParamQuery = sessionObj.createQuery(READ_BY_UUID);
            getUserByParamQuery.setParameter(0, uuid);
            return getUserByParamQuery.getSingleResult();
        }  catch (NoResultException nre) {
            throw new NoSuchUserException("No User with this UUID", nre);
        }catch (Exception e) {
            throw e;
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    public String getUUID(String username, String password) {
        try {
            sessionObj = sessionFactory.openSession();
            Query<User> getUserByUsernamePw = sessionObj.createQuery(READ_BY_USERNAME_PW);
            getUserByUsernamePw.setParameter(0, username);
            getUserByUsernamePw.setParameter(1, password);
            return getUserByUsernamePw.getSingleResult().getUserUUID();
        } catch (NoResultException nre) {
            throw new UserCredentialsNotAuthorizedException("No User with such credentials");
        } catch (Exception e) {
            throw e;
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    @Override
    public User save(User user) {
        try {
            if(existsUser(user.getUsername())){
                throw new UsernameAlreadyExistsException("Username taken");
            }
            user.setUserUUID(UUID.randomUUID().toString());
            sessionObj = sessionFactory.openSession();
            sessionObj.beginTransaction();
            long savedId = (long) sessionObj.save(user);
            sessionObj.getTransaction().commit();
            return get(savedId);
        } catch (Exception e) {
            if (null != sessionObj.getTransaction()) {
                sessionObj.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    @Override
    public User update(User updated) {
        try {
            User current = getUUID(updated.getUserUUID());
            if(current == null){
                throw new NoSuchUserException("No User with this UUID");
            }
            if(!current.getUsername().equals(updated.getUsername()) && existsUser(updated.getUsername())){
                throw new UsernameAlreadyExistsException("Username already exists.");
            }
                updated.setId(current.getId());
            sessionObj = sessionFactory.openSession();
            sessionObj.beginTransaction();
            sessionObj.update(updated);
            sessionObj.getTransaction().commit();
            return getUUID(updated.getUserUUID());
        } catch (UsernameAlreadyExistsException e) {
            if (null != sessionObj.getTransaction()) {
                sessionObj.getTransaction().rollback();
            }
            throw e;
        } catch (Exception e) {
            if (null != sessionObj.getTransaction()) {
                sessionObj.getTransaction().rollback();
            }
            throw new UserUpdateNotPossibleException("Update Failed",e);
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    @Override
    public  User get(long id) {
        try {
            sessionObj = sessionFactory.openSession();
            Query<User> getAllUsersQuery = sessionObj.createQuery(READ_BY_ID);
            getAllUsersQuery.setParameter(0, id);
            return getAllUsersQuery.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            throw e;
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    private boolean existsUser(String username) {
        try {
            sessionObj = sessionFactory.openSession();
            Query<User> getUserByUsernamePw = sessionObj.createQuery(READ_BY_USERNAME);
            getUserByUsernamePw.setParameter(0, username);
            return getUserByUsernamePw.getSingleResult() != null;
        } catch (NoResultException nre) {
            return false;
        } catch (Exception e) {
            throw e;
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    @Override
    public void delete(User user) {
        throw new NotYetImplementedException();
    }
}
