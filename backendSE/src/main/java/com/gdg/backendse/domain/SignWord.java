package com.gdg.backendse.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class SignWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long signwordId;

    @Column(nullable = false, unique = true)
    private String word; // 수어 단어

    @Column(nullable = false)
    private String definition; // 단어 정의

    private String imageUrl; // 손동작 이미지 URL
    private String videoUrl; // 수어 영상 URL

    @Builder
    public SignWord(String word, String definition, String imageUrl, String videoUrl) {
        this.word = word;
        this.definition = definition;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
    }
}