package com.mock.flight.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MockProjectResponse{
    private boolean error;
    private int errorCode;
    private String errorMessage;
    private String errorCause;
    private Object data;

    public MockProjectResponse(boolean error, int errorCode, String errorMessage, String errorCause, Object data) {
        this.error = error;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorCause = errorCause;
        this.data = data;
    }

    public MockProjectResponse() {
    }

    public MockProjectResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
