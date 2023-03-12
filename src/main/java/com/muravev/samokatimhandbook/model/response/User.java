package com.muravev.samokatimhandbook.model.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private Long id;
    @NotBlank
    private String fullName;
    private Gender gender;
    @Email
    private String email;
    @NotBlank
    private String tel;
    @Past
    private LocalDate birthDate;

}
