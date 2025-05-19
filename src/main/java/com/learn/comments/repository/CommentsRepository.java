package com.learn.comments.repository;

import com.learn.comments.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
    Comment findCommentByUuid(String uuid);

    void deleteByUuid(String uuid);
}
