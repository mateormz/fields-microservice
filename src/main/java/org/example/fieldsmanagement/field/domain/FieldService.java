package org.example.fieldsmanagement.field.domain;

import org.example.fieldsmanagement.Equipment.domain.Equipment;
import org.example.fieldsmanagement.Equipment.infrastructure.EquipmentRepository;
import org.example.fieldsmanagement.field.infrastructure.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FieldService {

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<Field> findAll() {
        return fieldRepository.findAll();
    }

    public Field createField(Field field) {
        List<Equipment> existingEquipments = equipmentRepository.findAllById(
                field.getEquipments().stream().map(Equipment::getId).collect(Collectors.toList())
        );

        field.setEquipments(existingEquipments);

        return fieldRepository.save(field);
    }

    public void assignEquipment(Long fieldId, Long equipmentId) {
        Equipment equipment = equipmentRepository.findById(equipmentId).orElseThrow(() -> new RuntimeException("There is no equipment with id " + equipmentId));

        Field field = fieldRepository.findById(fieldId).orElseThrow(() -> new RuntimeException("There is no field with id " + fieldId));

        field.getEquipments().add(equipment);
        fieldRepository.save(field);
    }

    public Field findFieldById(Long fieldId) {
        return fieldRepository.findById(fieldId)
                .orElseThrow(() -> new RuntimeException("There is no field with id " + fieldId));
    }

    public Field updateField(Long fieldId, Field updatedField) {
        Field existingField = fieldRepository.findById(fieldId)
                .orElseThrow(() -> new RuntimeException("There is no field with id " + fieldId));

        existingField.setName(updatedField.getName());
        existingField.setType(updatedField.getType());
        existingField.setCapacity(updatedField.getCapacity());
        existingField.setHour_price(updatedField.getHour_price());

        List<Equipment> existingEquipments = equipmentRepository.findAllById(
                updatedField.getEquipments().stream().map(Equipment::getId).collect(Collectors.toList())
        );
        existingField.setEquipments(existingEquipments);

        return fieldRepository.save(existingField);
    }

    public void deleteField(Long fieldId) {
        if (!fieldRepository.existsById(fieldId)) {
            throw new RuntimeException("There is no field with id " + fieldId);
        }
        fieldRepository.deleteById(fieldId);
    }
}
