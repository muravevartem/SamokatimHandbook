package com.muravev.samokatimhandbook.error;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ApiErrorHandler {

    @ExceptionHandler
    public ResponseEntity<ApiError> handle(ApiException e) {
        log.error("Api error", e);
        return ResponseEntity.status(e.getStatus().getHttpStatus())
                .body(ApiError.builder()
                        .code(e.getStatus())
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handle(Exception e) {
        log.error("Internal server error", e);
        return ResponseEntity.status(StatusCode.INTERNAL_SERVER_ERROR.getHttpStatus())
                .body(ApiError.builder()
                        .code(StatusCode.INTERNAL_SERVER_ERROR)
                        .message(StatusCode.INTERNAL_SERVER_ERROR.getMessage())
                        .build());
    }
}
