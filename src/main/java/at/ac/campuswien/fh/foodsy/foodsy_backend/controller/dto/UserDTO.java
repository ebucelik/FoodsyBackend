package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Valid
public class UserDTO {

    @Size(min = 36, max = 36)
    private final String userUUID;
    @NotNull
    private final String username;
    @NotNull
    private final String firstname;
    @NotNull
    private final String surname;
    @NotNull
    private final String password;
    @NotNull
    private final String profileImage;

    public UserDTO(String userUUID, String username, String firstname, String surname, String password, String profileImage) {
        this.userUUID = userUUID;
        this.username = username;
        this.firstname = firstname;
        this.surname = surname;
        this.password = password;
        this.profileImage = profileImage;
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

    public String getProfileImage() { return profileImage; }
}
