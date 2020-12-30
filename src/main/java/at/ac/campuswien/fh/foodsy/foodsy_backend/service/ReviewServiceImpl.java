package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Review;
import at.ac.campuswien.fh.foodsy.foodsy_backend.repository.ReviewDaoImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{
    
    @Autowired
    ReviewDaoImpl reviewDao;

    @Override
    public Review reviewOrder(Review review) {
        return reviewDao.reviewOrder(review);
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

    @Override
    public long getAverageReviewPoint(String uuid) {
        return reviewDao.getAveragePoints(uuid);
    }

}
