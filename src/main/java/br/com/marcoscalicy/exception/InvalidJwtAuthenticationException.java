package br.com.marcoscalicy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidJwtAuthenticationException extends AuthenticationException {
    private static final long serialVersonUID = 1L;

    public InvalidJwtAuthenticationException(String exception){
        super(exception);
    }

}
