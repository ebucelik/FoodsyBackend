package at.ac.campuswien.fh.foodsy.foodsy_backend.model;

import org.hibernate.criterion.Order;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "REVIEW")
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "REVIEW_POINTS")
    private Integer reviewPoints;
    @Column(name = "REVIEW_TEXT")
    private String reviewText;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_ORDER_ID", nullable = false)
    private Ordering ordering;

    public Review() {}

    public Review(Integer reviewPoints, String reviewText, Ordering ordering) {
        this.reviewPoints = reviewPoints;
        this.reviewText = reviewText;
        this.ordering = ordering;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public void setOrdering(Ordering ordering) {
        this.ordering = ordering;
    }
}
