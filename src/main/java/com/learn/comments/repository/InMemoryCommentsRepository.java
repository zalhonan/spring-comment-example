package com.learn.comments.repository;

import com.learn.comments.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class InMemoryCommentsRepository {

    private final HashMap<String, Comment> COMMENTS = new HashMap<>();

    public Comment saveComment(Comment comment) {
        COMMENTS.put(comment.getUuid(), comment);
        return comment;
    }

    public Comment findCommentByUuid(String uuid) {
        return COMMENTS.get(uuid);
    }

    public List<Comment> findAllComments() {
        return COMMENTS.values().stream().toList();
    }

    public Comment deleteComment(String uuid) {
        return COMMENTS.remove(uuid);
    }
}
