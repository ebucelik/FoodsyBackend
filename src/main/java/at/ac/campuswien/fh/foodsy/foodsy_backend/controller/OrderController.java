package at.ac.campuswien.fh.foodsy.foodsy_backend.controller;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input.PostOrderingDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.output.GetOrderingDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.mapper.OrderMapper;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.*;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.OrderList;
import at.ac.campuswien.fh.foodsy.foodsy_backend.service.OrderService;
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
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/ordering")
    @ResponseStatus(HttpStatus.CREATED)
    public GetOrderingDTO createOrder(@Valid @RequestBody PostOrderingDTO postOrderingDTO) {
        try {
            return OrderMapper.orderingToGetDTO(orderService.saveOrder(postOrderingDTO));
        } catch (NoSuchUserException | NoSuchOfferException | OfferIsAlreadyOrderedException expected) {
            expected.printStackTrace();
            throw expected;
        } catch (Exception unexpected) {
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Internal Error while handling request", unexpected);
        }
    }

    @GetMapping("/ordering")
    @ResponseStatus(HttpStatus.OK)
    public OrderList getAllOrders(@Valid @NotNull @Size(min = 36, max = 36) @RequestParam String uuid) {
        try {
            List<GetOrderingDTO> getOrderingDTOS = new ArrayList<>();
            orderService.getOrders(uuid).forEach(x -> getOrderingDTOS.add(OrderMapper.orderingToGetDTO(x)));

            return new OrderList(getOrderingDTOS);
        } catch (Exception unexpected) {
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Internal Error while handling request", unexpected);
        }
    }

    @DeleteMapping("/ordering/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@Valid @PathVariable @NotNull long id) {
        try {
            orderService.deleteOrder(id);
        } catch (NoSuchOrderException expected) {
            expected.printStackTrace();
            throw expected;
        } catch (Exception unexpected) {
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Internal Error while handling request", unexpected);
        }
    }
}
