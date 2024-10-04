package org.example.fieldsmanagement.field.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.example.fieldsmanagement.Equipment.domain.Equipment;

import java.util.List;

@Entity
@Data
@Table(name = "field")
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "type", nullable = false)
    private FieldType type;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "hour_price", nullable = false)
    private Float hour_price;

    @ManyToMany
    @JoinTable(
            name = "field_equipments",
            joinColumns = @JoinColumn(name = "field_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    private List<Equipment> equipments;

    // Comments

    // TimeSlots
}
