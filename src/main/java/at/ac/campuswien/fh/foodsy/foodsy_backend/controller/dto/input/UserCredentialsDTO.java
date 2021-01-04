package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
public class UserCredentialsDTO {
    @NotNull
    private String username;
    @NotNull
    private String password;

    public UserCredentialsDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
