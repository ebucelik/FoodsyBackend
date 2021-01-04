package at.ac.campuswien.fh.foodsy.foodsy_backend.controller;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input.PostUserDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.output.GetUserDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.mapper.UserMapper;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.*;
import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.input.UserCredentialsDTO;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import at.ac.campuswien.fh.foodsy.foodsy_backend.service.UserService;

@Validated
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public GetUserDTO getUser(@Valid @NotNull @Size(min = 36, max = 36) @RequestParam String userUUID) {
        try {
            return UserMapper.userToGetDTO(userService.getUserByUUID(userUUID));
        } catch (NoSuchUserException expected) {
            expected.printStackTrace();
            throw expected;
        } catch (Exception unexpected) {
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Internal Error while handling request", unexpected);
        }
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public GetUserDTO createUser(@Valid @RequestBody PostUserDTO postUserDTO) {
        try {
            return UserMapper.userToGetDTO(userService.saveUser(UserMapper.postDtoToUser(postUserDTO)));
        } catch (IllegalArgumentException | UsernameAlreadyExistsException expected) {
            expected.printStackTrace();
            throw expected;
        } catch (Exception unexpected) {
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Internal Error while handling request", unexpected);
        }
    }

    @PutMapping("/user")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public GetUserDTO updateUser(@Valid @RequestBody PostUserDTO postUserDTO) {
        throw new NotYetImplementedException("Not yet implemented");
    }

    @PutMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String login(@Valid @RequestBody UserCredentialsDTO userCredentialsDTO) {
        try {
            return userService.loginByCredentials(userCredentialsDTO.getUsername(), userCredentialsDTO.getPassword());
        } catch (UserCredentialsNotAuthorizedException expected) {
            expected.printStackTrace();
            throw expected;
        } catch (Exception unexpected) {
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Internal Error while handling request", unexpected);
        }
    }
}
