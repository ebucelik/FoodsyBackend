package at.ac.campuswien.fh.foodsy.foodsy_backend.controller;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input.PostOfferDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.output.GetOfferDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.mapper.OfferMapper;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.ApiInternalProcessingException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.NoSuchOfferException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.NoSuchUserException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.OfferList;
import at.ac.campuswien.fh.foodsy.foodsy_backend.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
public class OfferController {

    @Autowired
    OfferService offerService;

    @GetMapping(value = "/offer", params = {"uuid"})
    @ResponseStatus(HttpStatus.OK)
    public OfferList getOffersByUuid(@Valid @NotNull @Size(min = 36, max = 36) @RequestParam String uuid){
        try{
            List<GetOfferDTO> getOfferDTOS = new ArrayList<>();
            offerService.getOffersByUuid(uuid).forEach(x-> getOfferDTOS.add(OfferMapper.offerToGetDto(x)));

            return new OfferList(getOfferDTOS);
        }catch (Exception unexpected){
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Internal Error while handling request", unexpected);
        }
    }

    @GetMapping(value = "/offer", params = {"mealName"})
    @ResponseStatus(HttpStatus.OK)
    public OfferList getOpenOffersByName(@Valid @NotNull @RequestParam String mealName){
        try{
            List<GetOfferDTO> getOfferDTOS = new ArrayList<>();
            offerService.getAllOpenOfferByName(mealName).forEach(x-> getOfferDTOS.add(OfferMapper.offerToGetDto(x)));

            return new OfferList(getOfferDTOS);
        }catch (Exception unexpected){
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Internal Error while handling request", unexpected);
        }
    }

    @GetMapping(value = "/offer", params = {})
    @ResponseStatus(HttpStatus.OK)
    public OfferList getAllOpenOffers(){
        try{
            List<GetOfferDTO> getOfferDTOS = new ArrayList<>();
            offerService.getAllOpenOffers().forEach(x-> getOfferDTOS.add(OfferMapper.offerToGetDto(x)));

            return new OfferList(getOfferDTOS);
        }catch (Exception unexpected){
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Internal Error while handling request", unexpected);
        }
    }

    @PostMapping("/offer")
    @ResponseStatus(HttpStatus.CREATED)
    public GetOfferDTO createOffer(@Valid @RequestBody PostOfferDTO getOfferDTO){
        try{
            return OfferMapper.offerToGetDto(offerService.saveOffer(getOfferDTO));
        }catch (NoSuchUserException expected){
            expected.printStackTrace();
            throw expected;
        }catch (Exception unexpected){
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Internal Error while handling request", unexpected);
        }
    }

    @DeleteMapping("/offer")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOffer(@Valid @PathVariable @NotNull long id) {
        try {
            offerService.deleteOffer(id);
        }catch (NoSuchOfferException expected){
            expected.printStackTrace();
            throw expected;
        }catch (Exception unexpected){
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Internal Error while handling request.", unexpected);
        }
    }
}
