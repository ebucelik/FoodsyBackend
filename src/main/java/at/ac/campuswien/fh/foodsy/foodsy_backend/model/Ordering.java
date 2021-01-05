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
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_OFFER_ID", unique = true, nullable = false)
    private Offer offer;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_USER_ID", nullable = false)
    private User user;

    public Ordering(){}

    public Ordering(Offer offer, User user) {
        this.offer = offer;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
