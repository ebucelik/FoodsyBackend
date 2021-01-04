package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input.PostOrderingDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Ordering;

import java.util.List;

public interface OrderService {

    List<Ordering> getOrders(String uuid);

    Ordering saveOrder(PostOrderingDTO ordering);

    void deleteOrder(long id);
}
