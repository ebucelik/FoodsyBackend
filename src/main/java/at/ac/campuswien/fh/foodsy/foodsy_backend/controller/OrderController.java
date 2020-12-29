package at.ac.campuswien.fh.foodsy.foodsy_backend.controller;

import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.ApiInternalProcessingException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Ordering;
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
    public List<Ordering> getAllOrders(@Valid @RequestParam String uuid){
        try {
            return orderService.getOrders(uuid);
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
