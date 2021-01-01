package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.mapper;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.OfferDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;


public class OfferMapper {

    public static Offer dtoToOffer(OfferDTO offerDTO){
        return new Offer(offerDTO.getUserUUID(), 
                offerDTO.getMealName(), 
                offerDTO.getCategory(), 
                offerDTO.getArea(), 
                offerDTO.getEncodedImage(),
                offerDTO.getIngredients(),
                offerDTO.getCurrentTimestamp()
        );
    }

    public static OfferDTO offerToDto(Offer offer){
        return new OfferDTO(offer.getId(), 
                offer.getUserUUID(), 
                offer.getMealName(), 
                offer.getCategory(), 
                offer.getArea(),
                offer.getEncodedImage(),
                offer.getIngredients(),
                offer.getCurrentTimestamp(),
                offer.getUser()
        );
    }
}
