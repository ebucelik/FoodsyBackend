package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Valid
public class PostUserDTO {

    @NotNull
    private final String username;
    @NotNull
    private final String firstname;
    @NotNull
    private final String surname;
    @NotNull
    private final String password;
    private final String profileImage;

    public PostUserDTO(String username, String firstname, String surname, String password, String profileImage) {
        this.username = username;
        this.firstname = firstname;
        this.surname = surname;
        this.password = password;
        this.profileImage = profileImage;
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

    public String getProfileImage() {
        return profileImage;
    }
}
