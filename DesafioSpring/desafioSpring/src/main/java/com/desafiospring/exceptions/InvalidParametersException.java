package com.desafiospring.exceptions;

public class InvalidParametersException extends Exception {
    public InvalidParametersException(){
        super("parametros invalidos");
    }
}
