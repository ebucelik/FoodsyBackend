package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.output;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Valid
public class GetUserDTO {

    @Size(min = 36, max = 36)
    @NotNull
    private final String userUUID;
    @NotNull
    private final String username;
    @NotNull
    private final String firstname;
    @NotNull
    private final String surname;
    private final String profileImage;

    public GetUserDTO(String userUUID, String username, String firstname, String surname, String profileImage) {
        this.userUUID = userUUID;
        this.username = username;
        this.firstname = firstname;
        this.surname = surname;
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

    public String getProfileImage() { return profileImage; }
}
