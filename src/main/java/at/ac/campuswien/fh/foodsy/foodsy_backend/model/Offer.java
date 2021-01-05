package at.ac.campuswien.fh.foodsy.foodsy_backend.model;

import java.io.Serializable;
import java.util.Date;
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
    @Column(name = "INGREDIENTS")
    private String ingredients;
    @Column(name = "TIMESTAMP")
    private Date timestamp;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_USER_ID", nullable = false)
    private User user;

    public Offer() {
    }

    public Offer(String mealName, String category, String area, String encodedImage, String ingredients, Date timestamp, User user) {
        this.mealName = mealName;
        this.category = category;
        this.area = area;
        this.encodedImage = encodedImage;
        this.ingredients = ingredients;
        this.timestamp = timestamp;
        this.user = user;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEncodedImage() {
        return encodedImage;
    }

    public void setEncodedImage(String encodedImage) {
        this.encodedImage = encodedImage;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

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
