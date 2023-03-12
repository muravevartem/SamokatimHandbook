package com.muravev.samokatimhandbook.model.response.equipment;

import com.muravev.samokatimhandbook.model.response.Organization;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Equipment {
    private Long id;
    private String name;
    private Organization owner;
    private EquipmentStatus status;

}
