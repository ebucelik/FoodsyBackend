package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Review;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDaoImpl implements ReviewDao {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    static Session session;
    private static final String READ_BY_ID = "SELECT r FROM Review r WHERE r.id = ?0";
    private static final String READ_ALL_REVIEWS = "SELECT r FROM Review r";
    private static final String READ_ALL_REVIEWS_BY_UUID = "SELECT r FROM Review r WHERE r.reviewedId = ?0";

    @Override
    public Review reviewOrder(Review review) {
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            long savedId = (long) session.save(review);
            session.getTransaction().commit();

            return getReviewById(savedId);
        } catch (HibernateException e) {

        }

        return null;
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

    @Override
    public long getAveragePoints(String uuid) {
        try{
            session = sessionFactory.openSession();
            Query<Review> getAllReviewsFromUuid = session.createQuery(READ_ALL_REVIEWS_BY_UUID);
            getAllReviewsFromUuid.setParameter(0, uuid);

            return calculateAveragePoints(getAllReviewsFromUuid.getResultList());
        }catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }

    private long calculateAveragePoints(List<Review> reviewList){
        try{
            long one = reviewList.stream().filter(num -> num.getReviewPoints() == 1).mapToInt(Review::getReviewPoints).count();
            long two = reviewList.stream().filter(num -> num.getReviewPoints() == 2).mapToInt(Review::getReviewPoints).count();
            long three = reviewList.stream().filter(num -> num.getReviewPoints() == 3).mapToInt(Review::getReviewPoints).count();
            long four = reviewList.stream().filter(num -> num.getReviewPoints() == 4).mapToInt(Review::getReviewPoints).count();
            long five = reviewList.stream().filter(num -> num.getReviewPoints() == 5).mapToInt(Review::getReviewPoints).count();

            long sum = one + two + three + four + five;

            if(sum == 0){
                return 0;
            }

            double average = ((one + 2*two + 3*three + 4*four + 5*five)/(sum));
            return Math.round(average);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("No Reviews found.");
        }
    }
}
