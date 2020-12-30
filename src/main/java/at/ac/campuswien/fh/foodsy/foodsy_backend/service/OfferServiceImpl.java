package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;
import at.ac.campuswien.fh.foodsy.foodsy_backend.repository.OfferDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService{

    @Autowired
    OfferDaoImpl offerDaoImpl;

    @Override
    public List<Offer> getOffersByUuid(String uuid) {
        return offerDaoImpl.getOffers(uuid);
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerDaoImpl.getAllOffers();
    }

    @Override
    public List<Offer> getAllOfferByName(String mealName) {
        return offerDaoImpl.getOffersByName(mealName);
    }

    @Override
    public Offer saveOffer(Offer offer) {
        return offerDaoImpl.save(offer);
    }

    @Override
    public Offer deleteOffer(Offer offer) {
        return offerDaoImpl.delete(offer);
    }
}
