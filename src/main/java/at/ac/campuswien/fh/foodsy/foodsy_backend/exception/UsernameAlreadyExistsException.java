package at.ac.campuswien.fh.foodsy.foodsy_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UsernameAlreadyExistsException extends IllegalStateException{

    public UsernameAlreadyExistsException(String msg){
        super(msg);
    }

    public UsernameAlreadyExistsException(String msg, Throwable cause){
        super(msg, cause);
    }
}
