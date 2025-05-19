package com.learn.comments.controller;

import com.learn.comments.model.Comment;
import com.learn.comments.service.CommentsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public Comment getCommentByUuid(@PathVariable String uuid) {
        return service.getCommentByUuid(uuid);
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return service.getAllComments();
    }

    @DeleteMapping("/{uuid}")
    public Comment deleteComment(@PathVariable String uuid) {
        return service.deleteComment(uuid);
    }
}

