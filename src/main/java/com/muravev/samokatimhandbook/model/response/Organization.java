package com.muravev.samokatimhandbook.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Accessors(chain = true)
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
