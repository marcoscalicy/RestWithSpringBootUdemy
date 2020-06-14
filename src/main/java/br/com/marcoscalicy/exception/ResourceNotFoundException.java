package br.com.marcoscalicy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersonUID = 1L;

    public ResourceNotFoundException(String exception){
        super(exception);
    }

}
