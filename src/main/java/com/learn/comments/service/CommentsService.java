package com.learn.comments.service;

import com.learn.comments.model.Comment;

import java.util.List;

public interface CommentsService {

    Comment saveComment(Comment comment);

    Comment getCommentByUuid(String uuid);

    List<Comment> getAllComments();

    Comment deleteComment(String uuid);
}
