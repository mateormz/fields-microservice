package org.example.fieldsmanagement.Equipment.application;

import org.example.fieldsmanagement.Equipment.domain.Equipment;
import org.example.fieldsmanagement.Equipment.domain.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("")
    public ResponseEntity<List<Equipment>> findAll() {
        return ResponseEntity.ok(equipmentService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Equipment> save(@RequestBody Equipment equipment) {
        Equipment savedEquipment = equipmentService.create(equipment);
        return ResponseEntity.ok(savedEquipment);
    }
}