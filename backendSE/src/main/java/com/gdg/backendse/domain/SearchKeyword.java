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
    private Long keywordId;

    @Column(name = "keyword_content")
    private String keywordContent;

    @Column(name = "lecture_time")
    private Timestamp lectureTime;

    @Builder
    public SearchKeyword(int keywordId, String keywordContent, Timestamp lectureTime){
        this.keywordId = keywordId;
        this.keywordContent = keywordContent;
        this.lectureTime = lectureTime;
    }
}
