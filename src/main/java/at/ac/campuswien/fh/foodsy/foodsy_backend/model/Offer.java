package at.ac.campuswien.fh.foodsy.foodsy_backend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "OFFER")
public class Offer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "MEALNAME")
    private String mealName;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "AREA")
    private String area;
    @Column(name = "ENCODED_IMAGE", columnDefinition = "TEXT")
    private String encodedImage;
    @Column(name = "ENCODED_IMAGE1", columnDefinition = "TEXT")
    private String encodedImage1;
    @Column(name = "ENCODED_IMAGE2", columnDefinition = "TEXT")
    private String encodedImage2;
    @Column(name = "INGREDIENTS")
    private String ingredients;
    @Column(name = "TIMESTAMP")
    private Date timestamp;
    @Column(name = "PRICE")
    private int price;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_USER_ID", nullable = false)
    private User user;

    public Offer() {
    }

    public Offer(String mealName, String category, String area, String encodedImage, String encodedImage1, String encodedImage2, String ingredients, Date timestamp, int price, User user) {
        this.mealName = mealName;
        this.category = category;
        this.area = area;
        this.encodedImage = encodedImage;
        this.encodedImage1 = encodedImage1;
        this.encodedImage2 = encodedImage2;
        this.ingredients = ingredients;
        this.timestamp = timestamp;
        this.price = price;
        this.user = user;
    }

    public String getMealName() {
        return mealName;
    }

    public String getCategory() {
        return category;
    }

    public String getArea() {
        return area;
    }

    public String getEncodedImage() {
        return encodedImage;
    }

    public String getEncodedImage1() {
        return encodedImage1;
    }

    public String getEncodedImage2() { return encodedImage2;}

    public String getIngredients() {
        return ingredients;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public User getUser() {
        return user;
    }

    public int getPrice(){return this.price;}

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
