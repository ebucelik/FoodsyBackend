package at.ac.campuswien.fh.foodsy.foodsy_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.NoResultException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchUserException extends RuntimeException {

    public NoSuchUserException(String msg) {
        super(msg);
    }

    public NoSuchUserException(String msg, Throwable cause) {
        super(msg,cause);
    }
}
