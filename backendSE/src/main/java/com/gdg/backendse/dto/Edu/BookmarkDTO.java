package com.gdg.backendse.dto.Edu;

import com.gdg.backendse.domain.Edu;
import lombok.Getter;

@Getter
public class BookmarkDTO {
    private Long eduId;
    private String title;
    private String content;
    private String videoUrl;

    public BookmarkDTO(Edu edu) {
        this.eduId = edu.getId();
        this.title = edu.getTitle();
        this.content = edu.getContent();
        this.videoUrl = edu.getVideoUrl();
    }

    // 정적 팩토리 메서드 → Edu 엔티티를 DTO로 변환
    public static BookmarkDTO from(Edu edu) {
        return new BookmarkDTO(edu);
    }
}

