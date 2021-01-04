package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input.PostOrderingDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.NoSuchOfferException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.NoSuchOrderException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.NoSuchUserException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Ordering;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.User;
import at.ac.campuswien.fh.foodsy.foodsy_backend.repository.OfferDao;
import at.ac.campuswien.fh.foodsy.foodsy_backend.repository.OfferDaoImpl;
import at.ac.campuswien.fh.foodsy.foodsy_backend.repository.OrderDao;
import at.ac.campuswien.fh.foodsy.foodsy_backend.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OfferDao offerDao;
    @Autowired
    private UserDao userDao;

    @Override
    public List<Ordering> getOrders(String uuid) {
        return orderDao.getAllOrdersByUuid(uuid);
    }

    @Override
    public Ordering saveOrder(PostOrderingDTO postOrderingDTO) {
        Optional<User> user = userDao.getUUID(postOrderingDTO.getUserUUID());
        Optional<Offer> offer = offerDao.getOfferById(postOrderingDTO.getOfferId());
        if (!user.isPresent()) {
            throw new NoSuchUserException("No User with this UUID");
        }
        if(!offer.isPresent()){
            throw new NoSuchOfferException("No such Offer");
        }
         return orderDao.save(new Ordering(offer.get(), user.get()));
    }

    @Override
    public void deleteOrder(long id) {
        Optional<Ordering> order = orderDao.getOrderById(id);
        if(!order.isPresent()){
            throw new NoSuchOrderException("NoSuchOrder");
        }
        orderDao.delete(order.get());
    }
}
