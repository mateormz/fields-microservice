package org.example.fieldsmanagement.comments.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.example.fieldsmanagement.field.domain.Field;

@Entity
@Data
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(name = "score", nullable = false)
    private Integer score;

    // User

    // Field
    @ManyToOne
    private Field field;
}
