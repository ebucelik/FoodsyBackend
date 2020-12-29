package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Ordering;
import at.ac.campuswien.fh.foodsy.foodsy_backend.repository.OrderDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderDaoImpl orderDaoImpl;

    @Override
    public List<Ordering> getOrders(String uuid) {
        return orderDaoImpl.getAllOrdersByUuid(uuid);
    }

    @Override
    public Ordering saveOrder(Ordering ordering) {
        return orderDaoImpl.save(ordering);
    }

    @Override
    public Ordering deleteOrder(Ordering ordering) {
        return orderDaoImpl.delete(ordering);
    }
}
