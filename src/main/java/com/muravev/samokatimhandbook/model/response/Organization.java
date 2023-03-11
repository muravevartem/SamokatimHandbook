package com.muravev.samokatimhandbook.model.response;

import lombok.Data;

import java.util.Set;

@Data
public class Organization {
    private Long id;
    private String name;
    private String fullName;
    private String inn;
    private OrganizationStatus status;
    private String tel;
    private String email;
    private Set<User> admins;
    private Set<User> leaders;

}
