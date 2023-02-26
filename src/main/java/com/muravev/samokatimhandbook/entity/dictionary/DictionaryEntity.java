package com.muravev.samokatimhandbook.entity.dictionary;

import com.muravev.samokatimhandbook.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class DictionaryEntity extends AbstractEntity<Long> {

    @Id
    @SequenceGenerator(name = "seq_dictionary", sequenceName = "seq_dictionary")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dictionary")
    private Long id;

    private String name;
}
