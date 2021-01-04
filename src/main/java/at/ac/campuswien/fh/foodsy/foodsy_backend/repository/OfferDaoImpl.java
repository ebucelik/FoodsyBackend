package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public class OfferDaoImpl implements OfferDao {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    static Session session;
    private static final String READ_ALL_OFFERS_BY_UUID = "SELECT distinct o FROM Offer o WHERE o.user.userUUID = ?0 ORDER BY o.timestamp desc";
    private static final String READ_BY_ID = "SELECT distinct o FROM Offer o WHERE o.id = ?0";
    private static final String READ_ALL_OPEN_OFFERS = "SELECT distinct o FROM Offer o WHERE NOT EXISTS(SELECT 1 FROM Ordering order WHERE order.offer.id = o.id) ORDER BY o.timestamp desc";
    private static final String READ_ALL_OPEN_OFFERS_BY_NAME = "SELECT distinct o FROM Offer o WHERE o.mealName LIKE ?0 AND NOT EXISTS(SELECT 1 FROM Ordering order WHERE order.offer.id = o.id) ORDER BY o.timestamp desc";

    @Override
    public List<Offer> getOffers(String uuid) {
        try {
            session = sessionFactory.openSession();
            Query<Offer> getOffersByUuid = session.createQuery(READ_ALL_OFFERS_BY_UUID);
            getOffersByUuid.setParameter(0, uuid);
            return getOffersByUuid.getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Offer> getAllOpenOffers() {
        try {
            session = sessionFactory.openSession();
            Query<Offer> getAllOffers = session.createQuery(READ_ALL_OPEN_OFFERS);

            return getAllOffers.getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Offer> getOpenOffersByName(String mealName) {
        try {
            session = sessionFactory.openSession();
            Query<Offer> getOffersByName = session.createQuery(READ_ALL_OPEN_OFFERS_BY_NAME);
            getOffersByName.setParameter(0, mealName + "%");
            return getOffersByName.getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Offer save(Offer offer) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            long savedId = (long) session.save(offer);
            session.getTransaction().commit();
            return getOfferById(savedId).orElse(null);
        } catch (Exception e) {
            if (null != session.getTransaction()) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Offer offer) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(offer);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (null != session.getTransaction()) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<Offer> getOfferById(long id) {
        try {
            session = sessionFactory.openSession();
            Query<Offer> getOffer = session.createQuery(READ_BY_ID);
            getOffer.setParameter(0, id);
            return Optional.of(getOffer.getSingleResult());
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
