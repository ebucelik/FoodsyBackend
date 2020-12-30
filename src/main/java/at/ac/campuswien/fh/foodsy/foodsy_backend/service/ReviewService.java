package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Review;
import java.util.List;

public interface ReviewService {
    
    Review reviewOrder(Review review);
    
    void deleteReview(Review review);
    
    Review getReviewById(Long id);
    
    List<Review> getAllReviews();

    long getAverageReviewPoint(String uuid);
}
