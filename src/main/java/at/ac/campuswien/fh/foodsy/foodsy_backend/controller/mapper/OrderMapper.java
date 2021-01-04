package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.mapper;
import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.output.GetOrderingDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Ordering;

public class OrderMapper {

    private OrderMapper(){};

    public static GetOrderingDTO orderingToGetDTO(Ordering ordering){
        return new GetOrderingDTO(ordering.getId(),UserMapper.userToGetDTO(ordering.getUser()),OfferMapper.offerToGetDto(ordering.getOffer()));
    }
}
