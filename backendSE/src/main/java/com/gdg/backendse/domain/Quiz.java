package com.gdg.backendse.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Long testId;

    @Column(name = "answer_image")
    private String answerImage;

    @Column(name = "test_content")
    private String testContent;

    @Builder
    public Quiz(String answerImage, String testContent){
        this.answerImage = answerImage;
        this.testContent = testContent;
    }
}
