package br.com.carloca.exceptions;

public class CostumerNotFoundException extends RuntimeException {
    public CostumerNotFoundException(String msg){
        super(msg);
    }
}
