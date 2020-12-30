package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OfferDaoImpl implements OfferDao{

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    static Session session;
    private static final String READ_ALL_OFFERS_BY_UUID = "SELECT o FROM Offer o WHERE o.userUUID = ?0";
    private static final String READ_BY_ID = "SELECT o FROM Offer o WHERE o.id = ?0";
    private static final String READ_ALL_OFFERS = "SELECT o FROM Offer o";
    private static final String READ_ALL_OFFERS_BY_NAME = "SELECT o FROM Offer o WHERE o.mealName LIKE ?0";

    @Override
    public List<Offer> getOffers(String uuid) {
        try{
            session = sessionFactory.openSession();
            Query<Offer> getOffersByUuid = session.createQuery(READ_ALL_OFFERS_BY_UUID);
            getOffersByUuid.setParameter(0, uuid);

            return getOffersByUuid.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Offer> getAllOffers() {
        try{
            session = sessionFactory.openSession();
            Query<Offer> getAllOffers = session.createQuery(READ_ALL_OFFERS);

            return getAllOffers.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Offer> getOffersByName(String mealName) {
        try{
            session = sessionFactory.openSession();
            Query<Offer> getOffersByName = session.createQuery(READ_ALL_OFFERS_BY_NAME);
            getOffersByName.setParameter(0, mealName + "%");

            return getOffersByName.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Offer getOfferById(long id) {
        try{
            session = sessionFactory.openSession();
            Query<Offer> getOffer = session.createQuery(READ_BY_ID);
            getOffer.setParameter(0, id);

            return getOffer.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Offer save(Offer offer) {
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            long savedId = (long) session.save(offer);
            session.getTransaction().commit();

            return getOfferById(savedId);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Offer delete(Offer offer) {

        Offer offerDeleted = offer;

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(offer);
            session.getTransaction().commit();

            return offerDeleted;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
