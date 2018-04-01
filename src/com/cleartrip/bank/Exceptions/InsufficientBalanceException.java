package com.cleartrip.bank.Exceptions;

/**
 * Created by gaakarsh on 01/04/18.
 */
public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(){

    }

    public InsufficientBalanceException(Throwable cause) { initCause(cause); }

    public InsufficientBalanceException(String message) { super(message); }

    public InsufficientBalanceException(String message, Throwable cause) {
        super(message);
        initCause(cause);
    }
}
