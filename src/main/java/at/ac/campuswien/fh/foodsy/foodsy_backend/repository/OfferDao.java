package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;

import java.util.List;
import java.util.Optional;

public interface OfferDao {
    List<Offer> getOffers(String uuid);

    List<Offer> getAllOpenOffers();

    List<Offer> getOpenOffersByName(String mealName);

    Offer save(Offer offer);

    void delete(Offer offer);

    Optional<Offer> getOfferById(long id);
}
