package at.ac.campuswien.fh.foodsy.foodsy_backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CHAT")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "FROM_USER")
    private String from_user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_CHATPOOL_ID", nullable = false)
    private ChatPool chatPool;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "TIME")
    private Date timestamp;

    public Chat(){}

    public Chat(String from_user, String message, Date timestamp){
        this.from_user = from_user;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getFrom_user() {
        return from_user;
    }

    public ChatPool getChatPool() {
        return chatPool;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setChatPool(ChatPool chatPool) {
        this.chatPool = chatPool;
    }
}
