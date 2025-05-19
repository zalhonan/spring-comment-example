package com.learn.comments.service.impl;

import com.learn.comments.model.Comment;
import com.learn.comments.repository.InMemoryCommentsRepository;
import com.learn.comments.service.CommentsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryCommentsServiceImpl implements CommentsService {

     private final InMemoryCommentsRepository commentsRepository;

     public Comment saveComment(Comment comment) {
         final Comment commentToSave = Comment
                 .builder()
                 .id(1000 + (long)(Math.random() * 90000))
                 .content(comment.getContent())
                 .uuid(java.util.UUID.randomUUID().toString())
                 .createdAt(java.time.LocalDateTime.now())
                 .build();

         return commentsRepository.saveComment(commentToSave);
     }

     public Comment findCommentByUuid(String uuid) {
         return commentsRepository.findCommentByUuid(uuid);
     }

     public List<Comment> findAllComments() {
         return commentsRepository.findAllComments();
     }

     public Comment deleteComment(String uuid) {
         return commentsRepository.deleteComment(uuid);
     }
}
