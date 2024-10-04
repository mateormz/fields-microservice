package org.example.fieldsmanagement.Equipment.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "type", nullable = false)
    private EquipmentType type;
}
