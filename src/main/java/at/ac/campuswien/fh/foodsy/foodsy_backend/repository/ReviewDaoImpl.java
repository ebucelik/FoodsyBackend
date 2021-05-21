package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Review;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class ReviewDaoImpl implements ReviewDao {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    static Session session;
    private static final String READ_BY_ID = "SELECT distinct r FROM Review r WHERE r.id = ?0";
    private static final String READ_ALL_REVIEWS_BY_REVIEWED_PERSON = "SELECT distinct r FROM Review r WHERE r.ordering.offer.user.userUUID = ?0";
    private static final String GET_REVIEW_QUANTITY_FROM_PERSON = "SELECT COUNT(r.id) FROM Review r WHERE r.ordering.offer.user.userUUID = ?0";
    private static final String GET_ALL_REVIEWS_FOR_PERSON = "SELECT distinct r FROM Review r WHERE r.ordering.offer.user.userUUID = ?0";

    @Override
    public Review reviewOrder(Review review) {
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            long savedId = (long) session.save(review);
            session.getTransaction().commit();
            return getReviewById(savedId).orElse(null);
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
    public void deleteReview(Review review) {
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            session.delete(review);
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
    public Optional<Review> getReviewById(Long id) {
        try {
            session = sessionFactory.openSession();
            Query<Review> getReviewById = session.createQuery(READ_BY_ID);
            getReviewById.setParameter(0, id);
            return Optional.of(getReviewById.getSingleResult());
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
    public List<Review> getAllReviewsForReviewedPerson(String uuid) {
        try {
            session = sessionFactory.openSession();
            Query<Review> getAllReviewsFromUuid = session.createQuery(READ_ALL_REVIEWS_BY_REVIEWED_PERSON);
            getAllReviewsFromUuid.setParameter(0, uuid);
            return getAllReviewsFromUuid.getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public long getReviewQuantity(String uuid) {
        try{
            session = sessionFactory.openSession();
            Query<Long> getReviewQuantity = session.createQuery(GET_REVIEW_QUANTITY_FROM_PERSON);
            getReviewQuantity.setParameter(0, uuid);
            return getReviewQuantity.getSingleResult();
        }catch (Exception e){
            throw e;
        }finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public List<Review> getReviewList(String uuid) {
        try{
            session = sessionFactory.openSession();
            Query<Review> getReviewList = session.createQuery(GET_ALL_REVIEWS_FOR_PERSON);
            getReviewList.setParameter(0, uuid);
            return getReviewList.getResultList();
        }catch (Exception exception){
            throw exception;
        }finally {
            if (session != null)
                session.close();
        }
    }
}
