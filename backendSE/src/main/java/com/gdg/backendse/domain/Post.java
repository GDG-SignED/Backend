package com.gdg.backendse.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(nullable = false)
    private String title; // 게시글 제목

    @Column(nullable = false)
    private String content; // 게시글 내용

    private int views; // 조회수

    private int commentCount; // 댓글 수

    private int likeCount; // 찜 수

    @Column(name = "created_at")
    private LocalDateTime createdAt; // 작성 시간

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; // 수정 시간

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // 작성자 (FK)
    private Member author;

    @Builder
    public Post(Long postId, String title, String content, int views, int commentCount, int likeCount, LocalDateTime createdAt, LocalDateTime updatedAt, Member author) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.views = views;
        this.commentCount = commentCount;
        this.likeCount = likeCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.author = author;
    }
}
