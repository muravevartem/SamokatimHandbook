package com.muravev.samokatimhandbook.error.data;

import lombok.Builder;
import lombok.Data;

@Data
public class BadField {
    private final String fieldName;
    private final String message;
}
