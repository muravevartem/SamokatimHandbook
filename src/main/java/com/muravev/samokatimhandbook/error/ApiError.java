package com.muravev.samokatimhandbook.error;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiError {

    private StatusCode code;
    private String message;
}
