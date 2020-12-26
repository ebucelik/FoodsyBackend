package at.ac.campuswien.fh.foodsy.foodsy_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserUpdateNotPossibleException extends RuntimeException{

    public UserUpdateNotPossibleException(String msg){
        super(msg);
    }

    public UserUpdateNotPossibleException(String msg, Throwable cause){
        super(msg, cause);
    }
}
