package com.cleartrip.bank.Exceptions;

/**
 * Created by gaakarsh on 01/04/18.
 */
public class DailyLimitExceedException extends RuntimeException {

    public DailyLimitExceedException(){

    }

    public DailyLimitExceedException(Throwable cause) { initCause(cause); }

    public DailyLimitExceedException(String message) { super(message); }

    public DailyLimitExceedException(String message, Throwable cause) {
        super(message);
        initCause(cause);
    }
}
