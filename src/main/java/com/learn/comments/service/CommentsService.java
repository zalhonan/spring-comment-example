package com.learn.comments.service;

import com.learn.comments.model.Comment;

import java.util.List;

public interface CommentsService {

    Comment saveComment(Comment comment);

    Comment findCommentByUuid(String uuid);

    List<Comment> findAllComments();

    Comment deleteComment(String uuid);
}
