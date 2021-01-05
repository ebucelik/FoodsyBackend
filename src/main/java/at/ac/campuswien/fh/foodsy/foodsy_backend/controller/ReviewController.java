package at.ac.campuswien.fh.foodsy.foodsy_backend.controller;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input.PostReviewDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.mapper.ReviewMapper;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.ApiInternalProcessingException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.NoSuchOrderException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.NoSuchUserException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Review;
import at.ac.campuswien.fh.foodsy.foodsy_backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Validated
@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/review")
    @ResponseStatus(HttpStatus.CREATED)
    public void createReview(@Valid @RequestBody PostReviewDTO postReviewDTO) {
        try {
            reviewService.reviewOrder(postReviewDTO);
        } catch (NoSuchOrderException expected) {
            expected.printStackTrace();
            throw expected;
        } catch (Exception unexpected) {
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Something went wrong.", unexpected);
        }
    }

    @GetMapping("/reviewAverage")
    @ResponseStatus(HttpStatus.OK)
    public long getAverageReviewPoints(@Valid @NotNull @Size(min = 36, max = 36) @RequestParam String uuid) {
        try {
            return reviewService.getAverageReviewPoint(uuid);
        } catch (Exception unexpected) {
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Something went wrong.");
        }
    }
}
