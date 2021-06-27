package at.ac.campuswien.fh.foodsy.foodsy_backend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

    private static final long serialVersionUID = 2214488851494822078L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name="USER_UUID", unique = true)
    private String userUUID;
    @Column(name="USERNAME")
    private String username;
    @Column(name="FIRSTNAME")
    private String firstname;
    @Column(name="SURNAME")
    private String surname;
    @Column(name="PASSWORD")
    private String password;
    @Column(name = "ENCODEDIMAGE", columnDefinition = "TEXT")
    private String profileImage;

    public User() {}

    public User(String userUUID, String username, String firstname, String surname, String password, String profileImage) {
        this.userUUID = userUUID;
        this.username = username;
        this.firstname = firstname;
        this.surname = surname;
        this.password = password;
        this.profileImage = profileImage;
    }

    public long getId() {
        return id;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getProfileImage(){return  profileImage;}

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
