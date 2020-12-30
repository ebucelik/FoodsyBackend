package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Review;
import java.util.List;

public interface ReviewService {
    
    void reviewOrder(String reviewedId, String orderId, Integer reviewPoints, String reviewText);
    
    void deleteReview(Review review);
    
    Review getReviewById(Long id);
    
    List<Review> getAllReviews();
}
