package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Review;
import at.ac.campuswien.fh.foodsy.foodsy_backend.repository.ReviewDaoImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class ReviewServiceImpl implements ReviewService{
    
    @Autowired
    ReviewDaoImpl reviewDao;
    

    @Override
    public void reviewOrder(String reviewedId, String orderId, Integer reviewPoints, String reviewText) {
        reviewDao.reviewOrder(reviewedId, orderId, reviewPoints, reviewText);
    }

    @Override
    public void deleteReview(Review review) {
        reviewDao.deleteReview(review);
    }

    @Override
    public Review getReviewById(Long id) {
       return reviewDao.getReviewById(id);
    }

    @Override
    public List<Review> getAllReviews() {
       return reviewDao.getAllReviews();
    }
    
}
