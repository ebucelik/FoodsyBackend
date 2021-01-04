package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input.PostOfferDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.output.GetOfferDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.NoSuchOfferException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.NoSuchOrderException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.NoSuchUserException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Ordering;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.User;
import at.ac.campuswien.fh.foodsy.foodsy_backend.repository.OfferDao;
import at.ac.campuswien.fh.foodsy.foodsy_backend.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService{

    @Autowired
    private OfferDao offerDao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<Offer> getOffersByUuid(String uuid) {
        return offerDao.getOffers(uuid);
    }

    @Override
    public List<Offer> getAllOpenOffers() {
        return offerDao.getAllOpenOffers();
    }

    @Override
    public List<Offer> getAllOpenOfferByName(String mealName) {
        return offerDao.getOpenOffersByName(mealName);
    }

    @Override
    public Offer saveOffer(PostOfferDTO postOfferDTO) {
        Optional<User> user = userDao.getUUID(postOfferDTO.getUserUUID());
        if(!user.isPresent()){
            throw new NoSuchUserException("No User with this UUID");
        }
        return offerDao.save(new Offer(postOfferDTO.getMealName(),
                postOfferDTO.getCategory(),postOfferDTO.getArea(),
                postOfferDTO.getEncodedImage(),postOfferDTO.getIngredients(),
                postOfferDTO.getTimestamp(),user.get()));
    }

    @Override
    public void deleteOffer(long id) {
        Optional<Offer> offer = offerDao.getOfferById(id);
        if(!offer.isPresent()){
            throw new NoSuchOfferException("NoSuchOffer");
        }
        offerDao.delete(offer.get());
    }
}
