package com.muravev.samokatimhandbook.model.request.equipment;

import com.muravev.samokatimhandbook.model.request.OrganizationRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class EquipmentRequest {
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    @Positive
    private Long ownerId;
    private Set<@Valid EquipmentParameterRequest> parameters;
}
