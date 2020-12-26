package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.mapper;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.UserDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.User;

public class UserMapper {

    private UserMapper(){}

    public static User dtoToUser(UserDTO userDTO){
        return new User(userDTO.getUserUUID(),userDTO.getUsername(),userDTO.getFirstname(),userDTO.getSurname(),userDTO.getPassword());
    }

    public static UserDTO userToDTO(User user){
        return new UserDTO(user.getUserUUID(),user.getUsername(),user.getFirstname(),user.getSurname(),null);
    }
}
