package br.com.marcoscalicy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionOperadorNaoSuportado extends RuntimeException{
    private static final long serialVersonUID = 1L;

    public ExceptionOperadorNaoSuportado(String exception){
        super(exception);
    }

}
