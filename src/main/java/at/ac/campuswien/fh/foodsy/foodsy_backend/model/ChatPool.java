package at.ac.campuswien.fh.foodsy.foodsy_backend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CHATPOOL")
public class ChatPool implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_USER_ID", nullable = false)
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_WITH_USER_ID", nullable = false)
    private User withUser;

    @OneToMany(mappedBy = "chatPool", fetch = FetchType.EAGER)
    private List<Chat> chat;

    public ChatPool(){}

    public ChatPool(User user, User withUser){
        this.user = user;
        this.withUser = withUser;
    }

    public User getWithUser() {
        return withUser;
    }

    public User getUser() {
        return user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setWithUser(User withUser) {
        this.withUser = withUser;
    }
}
