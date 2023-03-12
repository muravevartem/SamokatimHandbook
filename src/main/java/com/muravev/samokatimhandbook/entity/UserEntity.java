package com.muravev.samokatimhandbook.entity;

import com.muravev.samokatimhandbook.model.response.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "client")
@Getter
@Setter
public class UserEntity extends AbstractEntity<Long> {

    @Id
    @SequenceGenerator(name = "seq_client", sequenceName = "seq_client")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_client")
    private Long id;

    private String fullName;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String tel;

    private String email;

}
