package com.gdg.backendse.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long classId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content; //내용

    @Column(nullable = false)
    private int views; //조회수

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "video_path")
    private String videoPath;

    @ManyToOne(fetch = FetchType.LAZY) // 클래스:회원_다대일
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Class(Long classId, String title, String content, int views, String imagePath, String videoPath) {
        this.title = title;
        this.content = content;
        this.views = views;
        this.imagePath = imagePath;
        this.videoPath = videoPath;
        this.member = member;
    }
}
