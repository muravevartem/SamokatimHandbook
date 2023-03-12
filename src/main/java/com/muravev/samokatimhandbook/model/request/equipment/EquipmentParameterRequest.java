package com.muravev.samokatimhandbook.model.request.equipment;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EquipmentParameterRequest {
    @NotNull
    @Positive
    private Long attributeId;

    @NotBlank
    private String value;
}
