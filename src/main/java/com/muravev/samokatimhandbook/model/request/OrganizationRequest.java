package com.muravev.samokatimhandbook.model.request;

import com.muravev.samokatimhandbook.model.response.OrganizationStatus;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class OrganizationRequest {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String fullName;
    @Pattern(regexp = "^[\\d+]{10,12}$")
    private String inn;
    @NotBlank
    private String tel;
    @Email
    private String email;
}
