package com.learn.comments.service.impl;

import com.learn.comments.model.Comment;
import com.learn.comments.repository.CommentsRepository;
import com.learn.comments.service.CommentsService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository repository;

    @Override
    public Comment saveComment(Comment comment) {
        final Comment commentToSave = Comment
                .builder()
                .content(comment.getContent())
                .uuid(java.util.UUID.randomUUID().toString())
                .createdAt(java.time.LocalDateTime.now())
                .build();

        return repository.save(commentToSave);
    }

    @Override
    public Comment findCommentByUuid(String uuid) {
        return repository.findCommentByUuid(uuid);
    }

    @Override
    public List<Comment> findAllComments() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Comment deleteComment(String uuid) {
        Comment commentToDelete = repository.findCommentByUuid(uuid);
        repository.deleteByUuid(uuid);
        return commentToDelete;
    }
}
