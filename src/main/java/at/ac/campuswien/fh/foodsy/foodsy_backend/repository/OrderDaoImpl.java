package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.OfferIsAlreadyOrderedException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Ordering;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderDaoImpl implements OrderDao {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    static Session session;
    private static final String READ_ALL_ORDERS_BY_UUID = "Select distinct o FROM Ordering o WHERE o.user.userUUID = ?0 ORDER by o.id desc";
    private static final String READ_ORDER_BY_ID = "Select distinct o FROM Ordering o WHERE o.id = ?0";
    private static final String READ_ORDER_BY_OFFER_ID = "Select distinct o FROM Ordering o WHERE o.offer.id = ?0";

    @Override
    public List<Ordering> getAllOrdersByUuid(String uuid) {
        try {
            session = sessionFactory.openSession();
            Query<Ordering> getAllOrdersByUuid = session.createQuery(READ_ALL_ORDERS_BY_UUID);
            getAllOrdersByUuid.setParameter(0, uuid);
            return getAllOrdersByUuid.getResultList();
        } catch (Exception e) {
            throw e;
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Ordering save(Ordering ordering) {
        try {
            if (getOrderByOfferId(ordering.getOffer().getId()).isPresent()) {
                throw new OfferIsAlreadyOrderedException("This Offer is already ordered!");
            }
            session = sessionFactory.openSession();
            session.beginTransaction();
            long savedId = (long) session.save(ordering);
            session.getTransaction().commit();
            return getOrderById(savedId).orElse(null);
        } catch (Exception e) {
            if (null != session.getTransaction()) {
                session.getTransaction().rollback();
            }
            throw e;
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Ordering ordering) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(ordering);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (null != session.getTransaction()) {
                session.getTransaction().rollback();
            }
            throw e;
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<Ordering> getOrderById(long id) {
        try {
            session = sessionFactory.openSession();
            Query<Ordering> getOrderById = session.createQuery(READ_ORDER_BY_ID);
            getOrderById.setParameter(0, id);
            return Optional.of(getOrderById.getSingleResult());
        } catch (NoResultException nre) {
            return Optional.empty();
        } catch (Exception e) {
            throw e;
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private Optional<Ordering> getOrderByOfferId(long id) {
        try {
            session = sessionFactory.openSession();
            Query<Ordering> getOrderById = session.createQuery(READ_ORDER_BY_OFFER_ID);
            getOrderById.setParameter(0, id);
            return Optional.of(getOrderById.getSingleResult());
        } catch (NoResultException nre) {
            return Optional.empty();
        } catch (Exception e) {
            throw e;
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
