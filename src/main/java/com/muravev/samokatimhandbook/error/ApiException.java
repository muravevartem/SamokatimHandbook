package com.muravev.samokatimhandbook.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {
    private final StatusCode status;

    public ApiException(StatusCode code) {
        super(code.getMessage());
        this.status = code;
    }
}
