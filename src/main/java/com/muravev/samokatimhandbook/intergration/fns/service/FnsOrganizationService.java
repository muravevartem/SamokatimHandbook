package com.muravev.samokatimhandbook.intergration.fns.service;


import com.muravev.samokatimhandbook.model.response.Organization;

public interface FnsOrganizationService {
    Organization searchFirstByInn(String inn);
}
