package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Valid
public class OfferDTO {

    private final long id;
    @Size(min = 36, max = 36)
    private final String userUUID;
    @NotNull
    private final String mealName;
    @NotNull
    private final String category;
    @NotNull
    private final String area;

    public OfferDTO(long id, String userUUID, String mealName, String category, String area){
        this.id = id;
        this.userUUID = userUUID;
        this.mealName = mealName;
        this.category = category;
        this.area = area;
    }

    public String getUserUUID(){return this.userUUID;}
    public String getMealName(){return this.mealName;}
    public String getCategory(){return this.category;}
    public String getArea(){return this.area;}
    public long getId(){return this.id;}
}
