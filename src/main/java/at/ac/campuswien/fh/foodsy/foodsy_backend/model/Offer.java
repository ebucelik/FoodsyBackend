package at.ac.campuswien.fh.foodsy.foodsy_backend.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="OFFER")
public class Offer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "USER_UUID")
    private String userUUID;
    @Column(name = "MEALNAME")
    private String mealName;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "AREA")
    private String area;

    public Offer(){}

    public Offer(String userUUID, String mealName, String category, String area){
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
