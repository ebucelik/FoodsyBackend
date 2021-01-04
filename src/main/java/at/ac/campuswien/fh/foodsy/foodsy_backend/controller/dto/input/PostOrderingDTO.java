package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Valid
public class PostOrderingDTO {

    @Size(min = 36, max = 36)
    @NotNull
    private String userUUID;
    @NotNull
    private long offerId;

    public PostOrderingDTO(@Size(min = 36, max = 36) @NotNull String userUUID, @NotNull long offerId) {
        this.userUUID = userUUID;
        this.offerId = offerId;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public long getOfferId() {
        return offerId;
    }

    public void setOfferId(long offerId) {
        this.offerId = offerId;
    }
}
