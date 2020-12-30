package at.ac.campuswien.fh.foodsy.foodsy_backend.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ORDERING")
public class Ordering implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "ORDERING_UUID")
    private String orderingUuid;
    @Column(name = "OFFERING_UUID")
    private String offeringUuid;
    @Column(name = "OFFER_ID")
    private long offeringId;

    public Ordering(){}

    public Ordering(String orderingUuid, String offeringUuid, long offeringId){
        this.orderingUuid = orderingUuid;
        this.offeringUuid = offeringUuid;
        this.offeringId = offeringId;
    }

    public String getOrderingUuid(){return this.orderingUuid;}
    public String getOfferingUuid(){return this.offeringUuid;}
    public long getOfferingId(){return this.offeringId;}
    public long getId(){return this.id;}
}
