package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Valid
public class PostOfferDTO {

    @NotNull
    private String mealName;
    @NotNull
    private String category;
    @NotNull
    private String area;

    private String encodedImage;
    @NotNull
    private String ingredients;
    @NotNull
    private Date timestamp;
    @NotNull
    private double price;
    @Size(min = 36, max = 36)
    @NotNull
    private String userUUID;

    public PostOfferDTO(@NotNull String mealName, @NotNull String category, @NotNull String area,
                        @NotNull String encodedImage, @NotNull String ingredients, @NotNull Date timestamp,
                        @NotNull double price, @Size(min = 36, max = 36) @NotNull String userUUID) {
        this.mealName = mealName;
        this.category = category;
        this.area = area;
        this.encodedImage = encodedImage;
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

    public double getPrice(){return this.price;}

    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }
}
