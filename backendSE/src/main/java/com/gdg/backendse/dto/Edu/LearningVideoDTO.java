package com.gdg.backendse.dto.Edu;

import com.gdg.backendse.domain.LearningVideo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LearningVideoDTO {
    private final String title;
    private final String videoUrl;

    // 엔티티 → DTO 변환 메서드
    public static LearningVideoDTO fromEntity(LearningVideo video) {
        return new LearningVideoDTO(video.getTitle(), video.getVideoUrl());
    }
}
