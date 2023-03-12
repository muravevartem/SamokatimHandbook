package com.muravev.samokatimhandbook.intergration.fns.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DaDataOrganization {
    @JsonProperty("value")
    private String name;
    @JsonProperty("unrestricted_value")
    private String fullName;
    private DaDataOrganizationData data;

}
