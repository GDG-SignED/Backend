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
    private String title; // 클래스 제목

    @Column(nullable = false)
    private String content; // 클래스 내용

    @Column(nullable = false)
    private int views; // 조회수

    @Column(name = "image_path")
    private String imagePath; // 이미지 경로

    @Column(name = "video_path")
    private String videoPath; // 영상 경로

    @Builder
    public Class(Long classId, String title, String content, int views, String imagePath, String videoPath) {
        this.classId = classId;
        this.title = title;
        this.content = content;
        this.views = views;
        this.imagePath = imagePath;
        this.videoPath = videoPath;
    }
}
