package com.learn.comments.controller;

import com.learn.comments.model.Comment;
import com.learn.comments.service.CommentsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentsService service;

    @PostMapping
    public Comment saveComment(@RequestBody Comment comment) {
        return service.saveComment(comment);
    }

    @GetMapping("/{uuid}")
    public Comment findCommentByUuid(@PathVariable String uuid) {
        Comment comment = service.findCommentByUuid(uuid);
        if (comment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Comment with UUID %s not found", uuid));
        }
        return comment;
    }

    @GetMapping
    public List<Comment> findAllComments() {
        return service.findAllComments();
    }

    @DeleteMapping("/{uuid}")
    public Comment deleteComment(@PathVariable String uuid) {
        Comment comment = service.deleteComment(uuid);
        if (comment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Comment with UUID %s not found", uuid));
        }
        return comment;
    }
}

