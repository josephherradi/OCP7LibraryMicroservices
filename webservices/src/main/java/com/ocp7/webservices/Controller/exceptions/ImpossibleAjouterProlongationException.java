package com.ocp7.webservices.Controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

public class ImpossibleAjouterProlongationException extends RuntimeException{
    public ImpossibleAjouterProlongationException(String message){
        super(message);
    }
}
