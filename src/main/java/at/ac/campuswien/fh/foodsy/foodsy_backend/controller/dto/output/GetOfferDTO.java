package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.output;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
public class GetOfferDTO {

    @NotNull
    private long id;
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
    private Date currentTimestamp;
    @NotNull
    private int price;
    @NotNull
    private GetUserDTO user;

    public GetOfferDTO(@NotNull long id, @NotNull String mealName, @NotNull String category, @NotNull String area,
                       @NotNull String encodedImage, @NotNull String encodedImage1, @NotNull String encodedImage2,
                       @NotNull String ingredients, @NotNull Date currentTimestamp,
                       @NotNull int price, @NotNull GetUserDTO user) {
        this.id = id;
        this.mealName = mealName;
        this.category = category;
        this.area = area;
        this.encodedImage = encodedImage;
        this.encodedImage1 = encodedImage1;
        this.encodedImage2 = encodedImage2;
        this.ingredients = ingredients;
        this.currentTimestamp = currentTimestamp;
        this.price = price;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getCurrentTimestamp() {
        return currentTimestamp;
    }

    public void setCurrentTimestamp(Date currentTimestamp) {
        this.currentTimestamp = currentTimestamp;
    }

    public int getPrice(){return this.price;}

    public GetUserDTO getUser() {
        return user;
    }

    public void setUser(GetUserDTO user) {
        this.user = user;
    }
}
