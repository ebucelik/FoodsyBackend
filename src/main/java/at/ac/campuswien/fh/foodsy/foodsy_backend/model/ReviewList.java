package at.ac.campuswien.fh.foodsy.foodsy_backend.model;

import java.util.List;

public class ReviewList {

    private List<Review> reviewList;

    public ReviewList(List<Review> reviewList){
        this.reviewList = reviewList;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }
}
