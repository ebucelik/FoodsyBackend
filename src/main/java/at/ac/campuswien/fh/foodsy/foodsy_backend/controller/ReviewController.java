package at.ac.campuswien.fh.foodsy.foodsy_backend.controller;

import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.ApiInternalProcessingException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Review;
import at.ac.campuswien.fh.foodsy.foodsy_backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class ReviewController {
    
    @Autowired
    ReviewService reviewService;

    @PostMapping("/review")
    @ResponseStatus(HttpStatus.CREATED)
    public Review createReview(@Valid @RequestBody Review review){
        try{
            return reviewService.reviewOrder(review);
        }catch (Exception e){
            throw new ApiInternalProcessingException("Something went wrong.");
        }
    }

    @GetMapping("/review")
    @ResponseStatus(HttpStatus.OK)
    public List<Review> getAllReviews(){
        try{
            return reviewService.getAllReviews();
        }catch (Exception e){
            throw new ApiInternalProcessingException("Something went wrong.");
        }
    }

    @PostMapping("/reviewAverage")
    @ResponseStatus(HttpStatus.OK)
    public long getAverageReviewPoints(@Valid @RequestParam String uuid){
        try{
            return reviewService.getAverageReviewPoint(uuid);
        }catch (Exception e){
            throw new ApiInternalProcessingException("Something went wrong.");
        }
    }
}
