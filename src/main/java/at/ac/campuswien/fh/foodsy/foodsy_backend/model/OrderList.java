package at.ac.campuswien.fh.foodsy.foodsy_backend.model;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.output.GetOfferDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.output.GetOrderingDTO;

import java.util.List;

public class OrderList {
    private List<GetOrderingDTO> orderingList;

    public OrderList(List<GetOrderingDTO> orderingList){
        this.orderingList = orderingList;
    }

    public List<GetOrderingDTO> getOrderingList(){return this.orderingList;}
}
