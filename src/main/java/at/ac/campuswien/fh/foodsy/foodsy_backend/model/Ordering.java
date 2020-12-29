package at.ac.campuswien.fh.foodsy.foodsy_backend.model;

import javax.persistence.*;

@Entity
@Table(name = "ORDERING")
public class Ordering {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public long id;
    @Column(name = "ORDERING_UUID")
    public String orderingUuid;
    @Column(name = "OFFERING_UUID")
    public String offeringUuid;
    @Column(name = "OFFER_ID")
    public long offeringId;

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
