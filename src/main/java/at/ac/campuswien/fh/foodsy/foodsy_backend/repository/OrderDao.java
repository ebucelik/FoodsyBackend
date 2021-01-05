package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Offer;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Ordering;

import java.util.List;
import java.util.Optional;

public interface OrderDao {

    List<Ordering> getAllOrdersByUuid(String uuid);

    Ordering save(Ordering ordering);

    void delete(Ordering ordering);

    Optional<Ordering> getOrderById(long id);
}
