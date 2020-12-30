package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Review;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ReviewDaoImpl implements ReviewDao {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    static Session session;
    private static final String READ_BY_ID = "SELECT r FROM Review r WHERE r.id = ?0";
    private static final String READ_ALL_REVIEWS = "SELECT r FROM Review r";

    @Override
    public void reviewOrder(String reviewedId, String orderId, Integer reviewPoints, String reviewText) {
        Review review = new Review();
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            review.setReviewedId(reviewedId);
            review.setOrderId(orderId);
            review.setReviewPoints(reviewPoints);
            review.setReviewText(reviewText);
            session.save(review);
            session.getTransaction().commit();
        } catch (HibernateException e) {

        }
    }

    @Override
    public void deleteReview(Review review) {
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            session.delete(review);
            session.getTransaction().commit();
        } catch (HibernateException e) {

        }
    }

    @Override
    public Review getReviewById(Long id) {
        session = sessionFactory.openSession();
        Query<Review> getReviewById = session.createQuery(READ_BY_ID);
        getReviewById.setParameter(0, id);
        return getReviewById.getSingleResult();
    }

    @Override
    public List<Review> getAllReviews() {
       session = sessionFactory.openSession();
       Query<Review> getAllReviews = session.createQuery(READ_ALL_REVIEWS);
       return getAllReviews.getResultList();
    }

}
