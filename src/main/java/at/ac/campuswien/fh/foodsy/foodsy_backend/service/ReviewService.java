package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input.PostReviewDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Review;
import java.util.List;

public interface ReviewService {

    void reviewOrder(PostReviewDTO postReviewDTO);

    void deleteReview(long id);

    long getAverageReviewPoint(String uuid);
}
