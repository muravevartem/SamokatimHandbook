package com.muravev.samokatimhandbook.controller;

import com.muravev.samokatimhandbook.model.request.equipment.EquipmentRequest;
import com.muravev.samokatimhandbook.model.response.equipment.Equipment;
import com.muravev.samokatimhandbook.model.response.equipment.EquipmentParameter;
import com.muravev.samokatimhandbook.service.EquipmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/equipments")
@RequiredArgsConstructor
public class EquipmentController {
    private final EquipmentService equipmentService;


    @GetMapping
    public Page<Equipment> getAll(@PageableDefault Pageable pageable) {
        return equipmentService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public Equipment getOne(@PathVariable long id) {
        return equipmentService.getOne(id);
    }

    @GetMapping("/{id}/params")
    public Iterable<EquipmentParameter> getAllParameters(@PathVariable long id) {
        return equipmentService.getAllParameters(id);
    }

    @PostMapping
    public Equipment create(@Valid @RequestBody EquipmentRequest request) {
        return equipmentService.create(request);
    }

    @PutMapping("/{id}")
    public Equipment update(@PathVariable long id, @Valid @RequestBody EquipmentRequest request) {
        return equipmentService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        equipmentService.delete(id);
    }

}
