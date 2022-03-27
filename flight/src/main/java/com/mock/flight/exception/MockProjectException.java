package com.mock.flight.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MockProjectException extends Exception {
    private boolean error;
    private int errorCode;


    public MockProjectException() {
    }


    public MockProjectException(String message) {
        super(message);
    }

    public MockProjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public MockProjectException(Throwable cause) {
        super(cause);
    }

    public MockProjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
