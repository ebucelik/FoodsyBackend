package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.ChatPool;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public class ChatPoolDaoImpl implements ChatPoolDao{

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    static Session session;

    private static final String READ_BY_ID = "SELECT distinct c FROM ChatPool c WHERE c.id = ?0";
    private static final String GET_CHATPOOLS = "SELECT distinct c FROM ChatPool c WHERE c.user.userUUID = ?0 OR c.withUser.userUUID = ?1";
    private static final String CHECK_IF_CHAT_IS_AVAILABLE = "SELECT distinct c FROM ChatPool c WHERE c.user.userUUID = ?0 AND c.withUser.userUUID = ?1";

    @Override
    public List<ChatPool> getChatPool(String uuid) {
        try{
            session = sessionFactory.openSession();
            Query<ChatPool> query = session.createQuery(GET_CHATPOOLS);
            query.setParameter(0, uuid);
            query.setParameter(1, uuid);

            return query.getResultList();
        }catch (Exception e){
            throw e;
        }finally {
            if(session != null)
                session.close();
        }
    }

    @Override
    public ChatPool createChatPool(ChatPool chatPool) {
        try{
            if(this.checkIfChatIsAvailable(chatPool.getUser().getUserUUID(), chatPool.getWithUser().getUserUUID()) > 0 ||
                    this.checkIfChatIsAvailable(chatPool.getWithUser().getUserUUID(), chatPool.getUser().getUserUUID()) > 0){
                return null;
            }

            session = sessionFactory.openSession();
            session.beginTransaction();
            long savedId = (long) session.save(chatPool);
            session.getTransaction().commit();
            return getChatPoolById(savedId).orElse(null);
        }catch (Exception e){
            throw e;
        }finally {
            if(session != null)
                session.close();
        }
    }

    private long checkIfChatIsAvailable(String userUuid, String withUserUuid){
        try{
            session = sessionFactory.openSession();
            Query<ChatPool> query = session.createQuery(CHECK_IF_CHAT_IS_AVAILABLE);
            query.setParameter(0, userUuid);
            query.setParameter(1, withUserUuid);

            return query.stream().count();
        }catch (Exception e){
            throw e;
        }finally {
            if(session != null)
                session.close();
        }
    }

    private Optional<ChatPool> getChatPoolById(long id) {
        try {
            session = sessionFactory.openSession();
            Query<ChatPool> getChatPool = session.createQuery(READ_BY_ID);
            getChatPool.setParameter(0, id);
            return Optional.of(getChatPool.getSingleResult());
        } catch (NoResultException nre) {
            return Optional.empty();
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
