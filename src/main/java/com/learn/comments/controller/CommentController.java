package com.learn.comments.controller;

import com.learn.comments.model.Comment;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {

    @PostMapping
    public Comment postComment() {
        return Comment.builder()
                .id(1000L)
                .uuid("123")
                .content("This is a comment")
                .createdAt(java.time.LocalDateTime.now())
                .build();
    }

    @GetMapping("/{uuid}")
    public Comment getCommentByUuid(@PathVariable String uuid) {
        return Comment.builder()
                .id(1000L)
                .uuid(uuid)
                .content("This is a comment")
                .createdAt(java.time.LocalDateTime.now())
                .build();
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return List.of(
         Comment.builder()
                .id(1000L)
                .uuid("uuid")
                .content("This is a comment")
                .createdAt(java.time.LocalDateTime.now())
                .build(),
         Comment.builder()
                .id(1000L)
                .uuid("uuid")
                .content("This is a comment")
                .createdAt(java.time.LocalDateTime.now())
                .build()
        );
    }

    @DeleteMapping("/{uuid}")
    public String deleteComment(@PathVariable String uuid) {
        return String.format("Comment with UUID %s deleted successfully.", uuid);
    }
}

