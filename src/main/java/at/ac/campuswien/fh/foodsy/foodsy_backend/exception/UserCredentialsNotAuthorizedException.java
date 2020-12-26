package at.ac.campuswien.fh.foodsy.foodsy_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UserCredentialsNotAuthorizedException extends IllegalArgumentException{

    public UserCredentialsNotAuthorizedException(String msg){
        super(msg);
    }

    public UserCredentialsNotAuthorizedException(String msg, Throwable cause){
        super(msg, cause);
    }
}
