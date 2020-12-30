package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Review;
import java.util.List;

public interface ReviewDao {

    Review reviewOrder(Review review);

    void deleteReview(Review review);

    Review getReviewById(Long id);

    List<Review> getAllReviews();

    long getAveragePoints(String uuid);
}
