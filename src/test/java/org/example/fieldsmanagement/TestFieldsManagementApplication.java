package org.example.fieldsmanagement;

import org.springframework.boot.SpringApplication;

public class TestFieldsManagementApplication {

    public static void main(String[] args) {
        SpringApplication.from(FieldsManagementApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
