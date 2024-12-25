package br.com.bruno.carro.exception;

public class CarroException extends RuntimeException {

    public CarroException(String message) {
        super(String.valueOf(message));
    }

}
