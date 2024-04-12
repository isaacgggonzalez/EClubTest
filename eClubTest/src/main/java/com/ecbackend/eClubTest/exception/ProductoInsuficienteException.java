package com.ecbackend.eClubTest.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductoInsuficienteException extends Exception {
    public ProductoInsuficienteException(String mensaje) {super(mensaje);}
}
