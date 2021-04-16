package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input.PostOfferDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.output.GetOfferDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;

import javax.annotation.PostConstruct;
import java.util.List;

public interface OfferService {

    List<Offer> getOffersByUuid(String uuid);

    List<Offer> getAllOpenOffers();

    List<Offer> getAllOpenOfferByName(String mealName);

    Offer saveOffer(PostOfferDTO postOfferDTO);

    void deleteOffer(long id);
}
