package com.gdg.backendse.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
public class SearchKeyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyword_id")
    private int keywordId;

    @Column(name = "keyword_content", nullable = false)
    private String keywordContent;

    @Column(name = "lecture_time", nullable = true)
    private Timestamp lectureTime;

    @Builder
    public SearchKeyword(String keywordContent, Timestamp lectureTime){
        this.keywordContent = keywordContent;
        this.lectureTime = lectureTime;
    }
}
