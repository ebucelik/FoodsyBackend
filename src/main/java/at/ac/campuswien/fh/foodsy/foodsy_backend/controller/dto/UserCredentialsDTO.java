package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto;

import javax.validation.constraints.NotNull;

public class UserCredentialsDTO {
    @NotNull
    String username;
    @NotNull
    String password;

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
