package org.example.fieldsmanagement.comments.application;

import org.example.fieldsmanagement.comments.domain.Comments;
import org.example.fieldsmanagement.comments.domain.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @GetMapping("/")
    public ResponseEntity<String> welcomeApi() {
        String welcome = "welcome to fieldsmanagement";
        return  ResponseEntity.ok(welcome);
    }

    @PostMapping("/comments/create")
    public ResponseEntity<Comments> createComment(@RequestBody Comments comment) {
        Comments savedComment = commentsService.createComment(comment);
        return ResponseEntity.ok(savedComment);
    }

    @GetMapping("/comments/field/{fieldId}")
    public ResponseEntity<List<Comments>> getCommentsByFieldId(@PathVariable Long fieldId) {
        List<Comments> comments = commentsService.getCommentsByFieldId(fieldId);
        return ResponseEntity.ok(comments);
    }
}