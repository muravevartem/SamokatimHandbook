package com.muravev.samokatimhandbook.intergration.fns.service;

import com.muravev.samokatimhandbook.intergration.fns.model.DaDataOrganization;

import java.util.List;

public interface FnsOrganizationSearcher {
    List<DaDataOrganization> searchByInn(String inn);
}
