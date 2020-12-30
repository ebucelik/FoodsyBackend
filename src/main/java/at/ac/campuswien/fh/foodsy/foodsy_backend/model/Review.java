package at.ac.campuswien.fh.foodsy.foodsy_backend.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "REVIEW")
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "REVIEWED_ID")
    private String reviewedId;
    @Column(name = "ORDER_ID")
    private String orderId;
    @Column(name = "REVIEW_POINTS")
    private Integer reviewPoints;
    @Column(name = "REVIEW_TEXT")
    private String reviewText;

    public Review(String reviewedId, String orderId, Integer reviewPoints, String reviewText) {
        this.reviewedId = reviewedId;
        this.orderId = orderId;
        this.reviewPoints = reviewPoints;
        this.reviewText = reviewText;
    }

    public Review() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReviewedId() {
        return reviewedId;
    }

    public void setReviewedId(String reviewedId) {
        this.reviewedId = reviewedId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getReviewPoints() {
        return reviewPoints;
    }

    public void setReviewPoints(Integer reviewPoints) {
        this.reviewPoints = reviewPoints;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

}
