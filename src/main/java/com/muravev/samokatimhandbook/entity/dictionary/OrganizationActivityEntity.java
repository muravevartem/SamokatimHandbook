package com.muravev.samokatimhandbook.entity.dictionary;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "organization_activity")
@Getter
@Setter
public class OrganizationActivityEntity extends DictionaryEntity {

}
