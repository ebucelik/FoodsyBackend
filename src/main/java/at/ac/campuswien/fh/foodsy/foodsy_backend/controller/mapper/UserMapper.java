package at.ac.campuswien.fh.foodsy.foodsy_backend.controller.mapper;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input.PostUserDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.output.GetUserDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.User;

public class UserMapper {

    private UserMapper(){}

    public static User postDtoToUser(PostUserDTO postUserDTO){
        return new User(null, postUserDTO.getUsername(), postUserDTO.getFirstname(), postUserDTO.getSurname(), postUserDTO.getPassword(), postUserDTO.getProfileImage());
    }

    public static GetUserDTO userToGetDTO(User user){
        return new GetUserDTO(user.getId(),user.getUserUUID(), user.getUsername(),user.getFirstname(),user.getSurname(),user.getProfileImage());
    }
}
