package org.example.fieldsmanagement.Equipment.domain;

import org.example.fieldsmanagement.Equipment.infrastructure.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    public Equipment create(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }
}
