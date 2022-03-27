package com.mock.flight.security.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessegeResponse {

    private String messege;

    public MessegeResponse(String messege) {
        this.messege = messege;
    }
}
