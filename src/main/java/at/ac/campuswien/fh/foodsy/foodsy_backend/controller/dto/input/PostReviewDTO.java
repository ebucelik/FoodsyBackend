package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input.PostUserDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.output.GetOrderingDTO;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Valid
public class PostReviewDTO {

    @NotNull
    @Min(1)
    @Max(5)
    private Integer reviewPoints;
    @NotNull
    private long orderId;
    private String reviewText;

    public PostReviewDTO(@NotNull Integer reviewPoints, @NotNull long orderId, String reviewText) {
        this.reviewPoints = reviewPoints;
        this.orderId = orderId;
        this.reviewText = reviewText;
    }

    public Integer getReviewPoints() {
        return reviewPoints;
    }

    public void setReviewPoints(Integer reviewPoints) {
        this.reviewPoints = reviewPoints;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
