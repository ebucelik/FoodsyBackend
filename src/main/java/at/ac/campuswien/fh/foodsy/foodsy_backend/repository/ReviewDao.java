package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Review;
import java.util.List;
import java.util.Optional;

public interface ReviewDao {

    Review reviewOrder(Review review);

    void deleteReview(Review review);

    Optional<Review> getReviewById(Long id);

    List<Review> getAllReviewsForReviewedPerson(String uuid);

    long getReviewQuantity(String uuid);

    List<Review> getReviewList(String uuid);
}
