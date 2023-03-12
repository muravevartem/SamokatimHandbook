package com.muravev.samokatimhandbook.model.response;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Equipment {
    private Long id;
    @NotNull
    private EquipmentStatus status;

}
