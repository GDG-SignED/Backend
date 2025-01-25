package com.gdg.backendse.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(nullable = false)
    private String content; // 댓글 내용

    @Column(name = "created_at")
    private LocalDateTime createdAt; // 댓글 작성 시간

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // 댓글 작성자 (FK)
    private Member author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id") // 게시글 (FK)
    private Post post;

    @Builder
    public Comment(Long commentId, String content, LocalDateTime createdAt, Member author, Post post) {
        this.commentId = commentId;
        this.content = content;
        this.createdAt = createdAt;
        this.author = author;
        this.post = post;
    }
}
