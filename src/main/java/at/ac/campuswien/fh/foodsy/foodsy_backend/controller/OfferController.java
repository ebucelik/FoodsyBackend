package at.ac.campuswien.fh.foodsy.foodsy_backend.controller;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.OfferDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.mapper.OfferMapper;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.ApiInternalProcessingException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;
import at.ac.campuswien.fh.foodsy.foodsy_backend.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class OfferController {

    @Autowired
    OfferService offerService;

    @PostMapping("/offering")
    @ResponseStatus(HttpStatus.CREATED)
    public OfferDTO createOffer(@Valid @RequestBody OfferDTO offerDTO){
        try{
            return OfferMapper.offerToDto(offerService.saveOffer(OfferMapper.dtoToOffer(offerDTO)));
        }catch (Exception e){
            throw new ApiInternalProcessingException("Internal Error while handling request", e);
        }
    }

    @GetMapping("/offering")
    @ResponseStatus(HttpStatus.OK)
    public List<Offer> getOffersByUuid(@Valid @RequestParam String uuid){
        try{
            return offerService.getOffersByUuid(uuid);
        }catch (Exception e){
            throw new ApiInternalProcessingException("Internal Error while handling request", e);
        }
    }

    @GetMapping("/offeringAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Offer> getAllOffers(){
        try{
            return offerService.getAllOffers();
        }catch (Exception e){
            throw new ApiInternalProcessingException("Internal Error while handling request", e);
        }
    }

    @PostMapping("/offeringDelete")
    @ResponseStatus(HttpStatus.OK)
    public Offer deleteOffer(@Valid @RequestBody Offer offer){
        try{
            return offerService.deleteOffer(offer);
        }catch (Exception e){
            throw new ApiInternalProcessingException("Internal Error while handling request", e);
        }
    }
}
