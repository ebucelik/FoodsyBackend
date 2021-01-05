package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.output;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Valid
public class GetOrderingDTO {

    @NotNull
    private long id;
    @Size(min = 36, max = 36)
    @NotNull
    private GetUserDTO user;
    @NotNull
    private GetOfferDTO offer;

    public GetOrderingDTO(@NotNull long id, @Size(min = 36, max = 36) @NotNull GetUserDTO user, @NotNull GetOfferDTO offer) {
        this.id = id;
        this.user = user;
        this.offer = offer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GetUserDTO getUser() {
        return user;
    }

    public void setUser(GetUserDTO user) {
        this.user = user;
    }

    public GetOfferDTO getOffer() {
        return offer;
    }

    public void setOffer(GetOfferDTO offer) {
        this.offer = offer;
    }
}
