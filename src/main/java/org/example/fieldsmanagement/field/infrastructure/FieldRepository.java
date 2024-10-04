package org.example.fieldsmanagement.field.infrastructure;

import org.example.fieldsmanagement.field.domain.Field;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Field, Long> {
}