package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.mapper;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input.PostReviewDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Review;
import org.hibernate.cfg.NotYetImplementedException;


public class ReviewMapper {

    private ReviewMapper() {
    }

    public static Review dtoToReview(PostReviewDTO postReviewDTO) {
        throw new NotYetImplementedException();
    }
}
