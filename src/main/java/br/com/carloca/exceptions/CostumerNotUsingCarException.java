package br.com.carloca.exceptions;

public class CostumerNotUsingCarException extends RuntimeException {
    public CostumerNotUsingCarException(String s) {
        super(s);
    }
}
