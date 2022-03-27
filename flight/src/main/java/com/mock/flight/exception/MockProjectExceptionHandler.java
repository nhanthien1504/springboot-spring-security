package com.mock.flight.exception;

import com.mock.flight.model.MockProjectResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MockProjectExceptionHandler extends Throwable {


    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public MockProjectResponse handleControllerException(MockProjectException c) {
        MockProjectResponse response = new MockProjectResponse();
        response.setError(true);
        response.setErrorCode(200);
        response.setErrorMessage(c.getMessage());
        response.setErrorCause(String.valueOf(c.getCause()));
        return response;
    }

}
