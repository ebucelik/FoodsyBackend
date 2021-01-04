package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input.PostReviewDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.NoSuchOfferException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.NoSuchOrderException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.NoSuchReviewException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.NoSuchUserException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Ordering;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Review;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.User;
import at.ac.campuswien.fh.foodsy.foodsy_backend.repository.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDao reviewDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;

    @Override
    public void reviewOrder(PostReviewDTO postReviewDTO) {

        Optional<Ordering> ordering = orderDao.getOrderById(postReviewDTO.getOrderId());
        if (!ordering.isPresent()) {
            throw new NoSuchOrderException("No such Offer");
        }
        reviewDao.reviewOrder(new Review(postReviewDTO.getReviewPoints(), postReviewDTO.getReviewText(), ordering.get()));
    }

    @Override
    public void deleteReview(long id) {
        Optional<Review> review = reviewDao.getReviewById(id);
        if (!review.isPresent()) {
            throw new NoSuchReviewException("No such Review");
        }
        reviewDao.deleteReview(review.get());
    }

    @Override
    public long getAverageReviewPoint(String uuid) {
        return calculateAveragePoints(reviewDao.getAllReviewsForReviewedPerson(uuid));
    }

    private long calculateAveragePoints(List<Review> reviewList) {
            return Math.round((double) reviewList.stream().map(Review::getReviewPoints).reduce(0, Integer::sum)/reviewList.size());
    }

}
