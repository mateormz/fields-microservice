package org.example.fieldsmanagement.field.application;

import org.example.fieldsmanagement.field.domain.Field;
import org.example.fieldsmanagement.field.domain.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/field")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @GetMapping("")
    public ResponseEntity<List<Field>> getFields() {
        return ResponseEntity.ok(fieldService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Field> getFieldById(@PathVariable Long id) {
        Field field = fieldService.findFieldById(id);
        return ResponseEntity.ok(field);
    }

    @PostMapping("/create")
    public ResponseEntity<Field> createField(@RequestBody Field field) {
        Field savedField = fieldService.createField(field);
        return ResponseEntity.ok(savedField);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Field> updateField(@PathVariable Long id, @RequestBody Field updatedField) {
        Field updated = fieldService.updateField(id, updatedField);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteField(@PathVariable Long id) {
        fieldService.deleteField(id);
        return ResponseEntity.noContent().build();
    }
}