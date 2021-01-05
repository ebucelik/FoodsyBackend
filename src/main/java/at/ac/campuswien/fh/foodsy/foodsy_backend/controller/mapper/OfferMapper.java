package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.mapper;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.output.GetOfferDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.User;


public class OfferMapper {

    private OfferMapper(){};

    public static GetOfferDTO offerToGetDto(Offer offer) {
        return new GetOfferDTO(offer.getId(),
                offer.getMealName(),
                offer.getCategory(),
                offer.getArea(),
                offer.getEncodedImage(),
                offer.getIngredients(),
                offer.getTimestamp(), UserMapper.userToGetDTO(offer.getUser()));
    }
}
