package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Ordering;

import java.util.List;

public interface OrderService {
    List<Ordering> getOrdersWithOffer(List<Offer> offers, List<Ordering> orderings);

    List<Ordering> getOrders(String uuid);

    Ordering saveOrder(Ordering ordering);

    Ordering deleteOrder(Ordering ordering);
}
