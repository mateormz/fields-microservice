package org.example.fieldsmanagement.comments.application;

import org.example.fieldsmanagement.comments.domain.Comments;
import org.example.fieldsmanagement.comments.domain.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;


    @PostMapping("/create")
    public ResponseEntity<Comments> createComment(@RequestBody Comments comment) {
        Comments savedComment = commentsService.createComment(comment);
        return ResponseEntity.ok(savedComment);
    }

    @GetMapping("/field/{fieldId}")
    public ResponseEntity<List<Comments>> getCommentsByFieldId(@PathVariable Long fieldId) {
        List<Comments> comments = commentsService.getCommentsByFieldId(fieldId);
        return ResponseEntity.ok(comments);
    }
}