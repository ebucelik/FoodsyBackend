package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import java.util.Optional;
import java.util.UUID;
import javax.persistence.NoResultException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.NoSuchUserException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.UserCredentialsNotAuthorizedException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.UsernameAlreadyExistsException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    static Session sessionObj;
    private static final String READ_BY_UUID = "SELECT distinct u FROM User u WHERE u.userUUID = ?0";
    private static final String READ_BY_USERNAME_PW = "SELECT distinct u FROM User u WHERE u.username = ?0 AND u.password =?1";
    private static final String READ_BY_USERNAME = "SELECT distinct u FROM User u WHERE u.username = ?0";
    private static final String READ_BY_ID = "SELECT distinct u FROM User u WHERE u.id = ?0";

    @Override
    public Optional<User> getUUID(String uuid) {
        try {
            sessionObj = sessionFactory.openSession();
            Query<User> getUserByParamQuery = sessionObj.createQuery(READ_BY_UUID);
            getUserByParamQuery.setParameter(0, uuid);
            return Optional.of(getUserByParamQuery.getSingleResult());
        }  catch (NoResultException nre) {
            return Optional.empty();
        }catch (Exception e) {
            throw e;
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    @Override
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
            if(existsUserWithUsername(user.getUsername())){
                throw new UsernameAlreadyExistsException("Username taken");
            }
            user.setUserUUID(UUID.randomUUID().toString());
            sessionObj = sessionFactory.openSession();
            sessionObj.beginTransaction();
            long savedId = (long) sessionObj.save(user);
            sessionObj.getTransaction().commit();
            return get(savedId).orElse(null);
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
        //TODO finish
            Optional<User> current = getUUID(updated.getUserUUID());
            if(!current.isPresent()){
                throw new NoSuchUserException("No User with this UUID");
            }
            if(!current.get().getUsername().equals(updated.getUsername()) && existsUserWithUsername(updated.getUsername())){
                throw new UsernameAlreadyExistsException("Username already exists.");
            }
            throw new NotYetImplementedException();
    }

    @Override
    public void delete(User user) {
        try {
            sessionObj = sessionFactory.openSession();
            sessionObj.beginTransaction();
            sessionObj.delete(user);
            sessionObj.getTransaction().commit();
        }catch (Exception e) {
            throw e;
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    private Optional<User> get(long id) {
        try {
            sessionObj = sessionFactory.openSession();
            Query<User> getAllUsersQuery = sessionObj.createQuery(READ_BY_ID);
            getAllUsersQuery.setParameter(0, id);
            return Optional.of(getAllUsersQuery.getSingleResult());
        } catch (NoResultException nre) {
            return Optional.empty();
        } catch (Exception e) {
            throw e;
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    private boolean existsUserWithUsername(String username) {
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
}
