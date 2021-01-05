package at.ac.campuswien.fh.foodsy.foodsy_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class OfferIsAlreadyOrderedException extends IllegalStateException{

    public OfferIsAlreadyOrderedException(String msg){
        super(msg);
    }

    public OfferIsAlreadyOrderedException(String msg, Throwable cause){
        super(msg, cause);
    }
}
