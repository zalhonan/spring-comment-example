package com.learn.comments.controller;

import com.learn.comments.model.Comment;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
