package org.example.fieldsmanagement.comments.infrastructure;

import org.example.fieldsmanagement.comments.domain.Comments;
import org.example.fieldsmanagement.field.domain.Field;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentsRepository extends CrudRepository<Comments, Long> {
    List<Comments> findByField(Field field);
}
