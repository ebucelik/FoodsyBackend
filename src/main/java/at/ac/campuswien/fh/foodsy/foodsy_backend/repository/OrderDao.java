package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Ordering;

import java.util.List;

public interface OrderDao {
    List<Ordering> getOrdersWithOffers(List<Offer> offers, List<Ordering> orderings);

    List<Ordering> getAllOrdersByUuid(String uuid);

    Ordering save(Ordering ordering);

    Ordering delete(Ordering ordering);
}
