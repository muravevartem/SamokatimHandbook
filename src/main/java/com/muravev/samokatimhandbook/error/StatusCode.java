package com.muravev.samokatimhandbook.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum StatusCode {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Внутренняя ошибка сервера"),

    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "Ошибка валидации"),
    ORGANIZATION_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "Организация уже существует"),
    ORGANIZATION_NOT_FOUND(HttpStatus.NOT_FOUND, "Организация не найдена"),
    ORGANIZATION_IMPOSSIBLE_TO_VERIFY(HttpStatus.BAD_REQUEST, "Организация не может пройти верефикацию")

    ;

    private final HttpStatus httpStatus;
    private final String message;
}
