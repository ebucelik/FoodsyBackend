package at.ac.campuswien.fh.foodsy.foodsy_backend.controller;

import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.UserDTO;
import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.mapper.UserMapper;
import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.*;
import at.ac.campuswien.fh.foodsy.foodsy_backend.controller.dto.UserCredentialsDTO;
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
    public UserDTO getUser(@Valid @NotNull @Size(min = 36, max = 36) @RequestParam String userUUID) {
        try {
            return UserMapper.userToDTO(userService.getUserByUUID(userUUID));
        } catch (NoSuchUserException expected) {
            throw expected;
        } catch (Exception unexpected) {
            throw new ApiInternalProcessingException("Internal Error while handling request", unexpected);
        }
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
        try {
            if (userDTO.getUserUUID() != null) {
                throw new IllegalArgumentException("Post can only be called without UUID!");
            }
            return UserMapper.userToDTO(userService.saveUser(UserMapper.dtoToUser(userDTO)));
        } catch (IllegalArgumentException | UsernameAlreadyExistsException expected) {
            throw expected;
        } catch (Exception unexpected) {
            throw new ApiInternalProcessingException("Internal Error while handling request", unexpected);
        }
    }

    @PutMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO updateUser(@Valid @RequestBody UserDTO userDTO) {
        try {
            if (userDTO.getUserUUID() == null || userDTO.getUserUUID().isEmpty()) {
                throw new UserUpdateNotPossibleException("Update only with specified UUID!");
            }
            return UserMapper.userToDTO(userService.updateUser(UserMapper.dtoToUser(userDTO)));
        } catch (UserUpdateNotPossibleException | UsernameAlreadyExistsException expected) {
            throw expected;
        } catch (Exception unexpected) {
            throw new ApiInternalProcessingException("Internal Error while handling request", unexpected);
        }
    }

    @PutMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String login(@Valid @RequestBody UserCredentialsDTO userCredentialsDTO) {
        try {
            return userService.loginByCredentials(userCredentialsDTO.getUsername(), userCredentialsDTO.getPassword());
        } catch (UserCredentialsNotAuthorizedException expected) {
            throw expected;
        } catch (Exception unexpected) {
            throw new ApiInternalProcessingException("Internal Error while handling request", unexpected);
        }
    }
}
