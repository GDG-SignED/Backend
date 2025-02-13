package com.gdg.backendse.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class LearningVideo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoId;

    @Column(nullable = false, unique = true)
    private String title; // 영상 제목

    @Column(nullable = false)
    private String videoUrl; // 영상 URL

    @Builder
    public LearningVideo(String title, String videoUrl) {
        this.title = title;
        this.videoUrl = videoUrl;
    }
}
