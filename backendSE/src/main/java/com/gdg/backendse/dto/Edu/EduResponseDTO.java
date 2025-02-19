package com.gdg.backendse.dto.Edu;

import com.gdg.backendse.domain.Edu;
import com.gdg.backendse.domain.EduCategory;
import lombok.Getter;

@Getter
public class EduResponseDTO {
    private Long eduId;
    private String title;
    private String content;
    private String word;
    private String videoUrl;
    private int views;
    private String category;

    public EduResponseDTO(Edu edu) {
        this.eduId = edu.getId();
        this.title = edu.getTitle();
        this.content = edu.getContent();
        this.word = edu.getWord();
        this.videoUrl = edu.getVideoUrl();
        this.views = edu.getViews();
        this.category = edu.getCategory().name();
    }
}
