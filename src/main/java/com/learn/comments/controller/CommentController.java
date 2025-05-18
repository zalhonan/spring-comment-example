package com.learn.comments.controller;

import com.learn.comments.model.Comment;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {

    @GetMapping
    public List<Comment> getAllComments() {
        return List.of(
                Comment.builder().uuid("123").content("This is a comment").build(),
                Comment.builder().uuid("456").content("This is another comment").build()
        );
    }

    @GetMapping("/{uuid}")
    public Comment getCommentByUuid(@PathVariable String uuid) {
        return Comment.builder().uuid(uuid).content("This is a comment").build();
    }

    @PostMapping
    public String postComment() {
        return java.util.UUID.randomUUID().toString();
    }

    @PutMapping("/{uuid}")
    public String updateComment(@RequestParam String uuid) {
        return String.format("Comment with UUID %s updated successfully.", uuid);
    }

    @DeleteMapping("/{uuid}")
    public String deleteComment(@RequestParam String uuid) {
        return String.format("Comment with UUID %s deleted successfully.", uuid);
    }
}

