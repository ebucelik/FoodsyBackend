package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.ApiInternalProcessingException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Chat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public class ChatDaoImpl implements ChatDao {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    static Session session;

    private static final String READ_BY_ID = "SELECT distinct c FROM Chat c WHERE c.id = ?0";

    private static final String GET_CHAT_BY_CHATPOOLID = "SELECT distinct c FROM Chat c WHERE c.chatPool.id = ?0";

    @Override
    public Chat sendMessage(Chat chat) {
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            long savedId = (long) session.save(chat);
            session.getTransaction().commit();
            return getChatMessageById(savedId).orElse(null);
        }catch (Exception exception){
            throw new ApiInternalProcessingException("Send Message has thrown an error.");
        }finally {
            if(session != null)
                session.close();
        }
    }

    @Override
    public Optional<Chat> getChatMessageById(long id) {
        try {
            session = sessionFactory.openSession();
            Query<Chat> getChatMessage = session.createQuery(READ_BY_ID);
            getChatMessage.setParameter(0, id);
            return Optional.of(getChatMessage.getSingleResult());
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

    @Override
    public List<Chat> getChatListById(long id) {
        try {
            session = sessionFactory.openSession();
            Query<Chat> getChatList = session.createQuery(GET_CHAT_BY_CHATPOOLID);
            getChatList.setParameter(0, id);
            return getChatList.getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
