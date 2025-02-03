package com.gdg.backendse.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;


import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;

    @Column(name = "post_title", nullable = false)
    private String title;

    @Column(name = "post_content", nullable = false)
    private String content; //내용

    private int views; //조회수

    @Column(name = "comments_count")
    private int commentCount; //댓글 수

    @Column(name = "likes_count")
    private int likeCount; //찜 수

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; // 수정 시간

    @ManyToOne(fetch = FetchType.LAZY) //게시글:회원_다대일
    @JoinColumn(name = "writer_id")
    private Member author;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY) //게시글:댓글_일대다
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Post(Long postId, String title, String content, int views, int commentCount, int likeCount, LocalDateTime createdAt, LocalDateTime updatedAt, Member author) {
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
