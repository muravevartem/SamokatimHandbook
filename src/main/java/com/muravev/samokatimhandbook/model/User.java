package com.muravev.samokatimhandbook.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.apache.kafka.common.protocol.types.Field;

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
