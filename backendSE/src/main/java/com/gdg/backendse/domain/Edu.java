package com.gdg.backendse.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Edu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title; // 교육 제목

    @Column(nullable = false)
    private String content; // 교육 내용

    @Column(nullable = false)
    private String word; // 학습할 단어

    @Column(nullable = false)
    private String videoUrl; // 학습 영상 URL

    @Column(nullable = false)
    private int views; // 조회수

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EduCategory category; // 교육 카테고리

    @Builder
    public Edu(String title, String content, String word, String videoUrl, int views, EduCategory category) {
        this.title = title;
        this.content = content;
        this.word = word;
        this.videoUrl = videoUrl;
        this.views = views;
        this.category = category;
    }

    //  단어 기반 카테고리 자동 설정
    public static EduCategory determineCategory(String word) {
        if (word.matches("[ㄱ-ㅎ]")) { // 자음
            return EduCategory.CONSONANT;
        } else if (word.matches("[ㅏ-ㅣ]")) { // 모음
            return EduCategory.VOWEL;
        } else {
            return EduCategory.BASIC_WORD; // 기본 단어
        }
    }
}
