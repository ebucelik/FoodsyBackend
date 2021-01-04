package at.ac.campuswien.fh.foodsy.foodsy_backend.model;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.output.GetOfferDTO;

import java.util.List;

public class OfferList {
    private List<GetOfferDTO> offeringList;

    public OfferList(List<GetOfferDTO> offeringList){
        this.offeringList = offeringList;
    }

    public List<GetOfferDTO> getOfferingList(){return this.offeringList;}

}
