package com.liushuqing.regel.core.exception;

/**
 * Created by liushuqing on 2017/8/11.
 */
public class UnitRunException extends Exception {

    public UnitRunException(String message) {
        super(message);
    }

    public UnitRunException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnitRunException(Throwable cause) {
        super(cause);
    }
}
