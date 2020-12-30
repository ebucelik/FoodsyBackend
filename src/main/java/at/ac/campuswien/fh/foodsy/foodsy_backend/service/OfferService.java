package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;

import java.util.List;

public interface OfferService {

    List<Offer> getOffersByUuid(String uuid);

    List<Offer> getAllOffers();

    List<Offer> getAllOfferByName(String mealName);

    Offer saveOffer(Offer offer);

    Offer deleteOffer(Offer offer);
}
