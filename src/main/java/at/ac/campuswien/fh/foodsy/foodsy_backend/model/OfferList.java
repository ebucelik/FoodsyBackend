package at.ac.campuswien.fh.foodsy.foodsy_backend.model;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.OfferDTO;

import java.util.List;

public class OfferList {
    private List<Offer> offerList;

    public void setOfferList(List<Offer> offerList){this.offerList = offerList;}
    public List<Offer> getOfferList(){return this.offerList;}
}
