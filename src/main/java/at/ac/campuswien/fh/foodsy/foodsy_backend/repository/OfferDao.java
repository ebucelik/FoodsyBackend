package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;

import java.util.List;

public interface OfferDao {
    List<Offer> getOffers(String uuid);

    List<Offer> getAllOffers();

    Offer getOfferById(long id);

    Offer save(Offer offer);

    Offer delete(Offer offer);
}
