package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Valid
public class PostOfferDTO {

    @NotNull
    private String mealName;
    @NotNull
    private String category;
    @NotNull
    private String area;
    @NotNull
    private String encodedImage;
    @NotNull
    private String encodedImage1;
    @NotNull
    private String encodedImage2;
    @NotNull
    private String ingredients;
    @NotNull
    private Date timestamp;
    @NotNull
    private int price;
    @Size(min = 36, max = 36)
    @NotNull
    private String userUUID;

    public PostOfferDTO(@NotNull String mealName, @NotNull String category, @NotNull String area,
                        @NotNull String encodedImage, @NotNull String encodedImage1, @NotNull String encodedImage2,
                        @NotNull String ingredients, @NotNull Date timestamp,
                        @NotNull int price, @Size(min = 36, max = 36) @NotNull String userUUID) {
        this.mealName = mealName;
        this.category = category;
        this.area = area;
        this.encodedImage = encodedImage;
        this.encodedImage1 = encodedImage1;
        this.encodedImage2 = encodedImage2;
        this.ingredients = ingredients;
        this.timestamp = timestamp;
        this.price = price;
        this.userUUID = userUUID;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealname) {
        this.mealName = mealname;
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

    public String getEncodedImage1() {
        return encodedImage1;
    }

    public void setEncodedImage1(String encodedImage) {
        this.encodedImage1 = encodedImage;
    }

    public String getEncodedImage2() {
        return encodedImage2;
    }

    public void setEncodedImage2(String encodedImage) {
        this.encodedImage2 = encodedImage;
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

    public int getPrice(){return this.price;}

    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }
}
