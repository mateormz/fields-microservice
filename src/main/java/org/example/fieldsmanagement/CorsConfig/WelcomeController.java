package org.example.fieldsmanagement.CorsConfig;

import org.example.fieldsmanagement.comments.domain.Comments;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WelcomeController {

    @GetMapping("/")
    public ResponseEntity<String> createComment() {
        String welcome = "welcome to fieldsmanagement";
        return ResponseEntity.ok(welcome);
    }

}
