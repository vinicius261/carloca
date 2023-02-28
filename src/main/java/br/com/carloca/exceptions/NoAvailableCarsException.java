package br.com.carloca.exceptions;

public class NoAvailableCarsException extends RuntimeException {
    public NoAvailableCarsException(String msg) {
        super(msg);
    }
}
