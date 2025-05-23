package com.learn.comments.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(indexes = {
        @Index(name = "idx_comment_uuid", columnList = "uuid")
})
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String uuid;
    private String content;
    private java.time.LocalDateTime createdAt;
}