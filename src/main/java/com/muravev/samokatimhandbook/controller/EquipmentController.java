package com.muravev.samokatimhandbook.controller;

import com.muravev.samokatimhandbook.model.Equipment;
import com.muravev.samokatimhandbook.model.EquipmentStatus;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EquipmentController {

    @GetMapping
    public Page<Equipment> getAll(Pageable pageable) {

    }

    @GetMapping(params = "s")
    public Page<Equipment> getAll(@RequestParam("s") List<EquipmentStatus> statuses,
                                  Pageable pageable) {

    }

    @GetMapping("/{id}")
    public Equipment getOne(@PathVariable("id") long id) {

    }

    @PostMapping
    public Equipment create(@RequestBody Equipment equipment) {

    }

    @PutMapping("/{id}")
    public Equipment update(@PathVariable("id") long id,
                            @RequestBody Equipment equipment) {

    }

    @DeleteMapping("/{id}")
    public Equipment delete(@PathVariable("id") String id) {

    }

}
