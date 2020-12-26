package at.ac.campuswien.fh.foodsy.foodsy_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom Exception for unexpected Server Errors while processing HTTP-API Requests.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ApiInternalProcessingException extends RuntimeException{

    public ApiInternalProcessingException(String msg){
        super(msg);
    }

    public ApiInternalProcessingException(String msg, Throwable cause){
        super(msg, cause);
    }
}
