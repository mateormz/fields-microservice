package org.example.fieldsmanagement.comments.domain;

import org.example.fieldsmanagement.comments.infrastructure.CommentsRepository;
import org.example.fieldsmanagement.field.domain.Field;
import org.example.fieldsmanagement.field.infrastructure.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private FieldRepository fieldRepository;

    public Comments createComment(Comments comment) {
        Field field = fieldRepository.findById(comment.getField().getId())
                .orElseThrow(() -> new RuntimeException("Field not found"));

        comment.setField(field);

        return commentsRepository.save(comment);
    }

    public List<Comments> getCommentsByFieldId(Long fieldId) {
        Field field = fieldRepository.findById(fieldId)
                .orElseThrow(() -> new RuntimeException("Field not found"));

        return commentsRepository.findByField(field);
    }
}
