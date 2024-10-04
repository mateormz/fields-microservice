package org.example.fieldsmanagement.Equipment.infrastructure;

import org.example.fieldsmanagement.Equipment.domain.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
