package at.ac.campuswien.fh.foodsy.foodsy_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchOfferException extends RuntimeException {

    public NoSuchOfferException(String msg) {
        super(msg);
    }

    public NoSuchOfferException(String msg, Throwable cause) {
        super(msg,cause);
    }
}
