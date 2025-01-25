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

    @Column(name = "keyword_content", nullable = false)
    private String keywordContent;

    @Column(name = "lecture_time", nullable = true)
    private Timestamp lectureTime;

    @ManyToOne(fetch = FetchType.LAZY) //검색어:회원_다대일
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public SearchKeyword(String keywordContent, Timestamp lectureTime){
        this.keywordContent = keywordContent;
        this.lectureTime = lectureTime;
        this.member = member;
    }
}
