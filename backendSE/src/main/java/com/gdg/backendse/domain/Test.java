package com.gdg.backendse.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private int testId;

    @Column(name = "answer_image")
    private String answerImage;

    @Column(name = "test_content")
    private String testContent;

    @ManyToOne(fetch = FetchType.LAZY) //퀴즈:회원_다대일
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Test(String answerImage, String testContent){
        this.answerImage = answerImage;
        this.testContent = testContent;
        this.member = member;
    }
}
