package at.ac.campuswien.fh.foodsy.foodsy_backend.controller;

import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.ApiInternalProcessingException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Ordering;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.OrderingList;
import at.ac.campuswien.fh.foodsy.foodsy_backend.service.OfferService;
import at.ac.campuswien.fh.foodsy.foodsy_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OfferService offerService;

    @PostMapping("/ordering")
    @ResponseStatus(HttpStatus.CREATED)
    public Ordering createOrder(@Valid @RequestBody Ordering ordering){
        try{
            return orderService.saveOrder(ordering);
        }catch (Exception e){
            throw new ApiInternalProcessingException("Internal Error while handling request", e);
        }
    }

    @GetMapping("/ordering")
    @ResponseStatus(HttpStatus.OK)
    public OrderingList getAllOrders(@Valid @RequestParam String uuid){
        try {
            OrderingList orderingList = new OrderingList();
            orderingList.setOrderingList(orderService.getOrdersWithOffer(offerService.getAllOffers(), orderService.getOrders(uuid)));
            return orderingList;
        }catch (Exception e){
            throw new ApiInternalProcessingException("Internal Error while handling request", e);
        }
    }

    @PostMapping("/orderingDelete")
    @ResponseStatus(HttpStatus.OK)
    public Ordering deleteOrder(@Valid @RequestBody Ordering ordering){
        try{
            return orderService.deleteOrder(ordering);
        }catch (Exception e){
            throw new ApiInternalProcessingException("Internal Error while handling request", e);
        }
    }
}
