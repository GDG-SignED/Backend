package com.gdg.backendse.dto.Edu;

import com.gdg.backendse.domain.Edu;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EduRequestDTO {
    private String title;
    private String content;
    private String word;
    private String videoUrl;

    public Edu toEntity() {
        return Edu.builder()
                .title(title)
                .content(content)
                .word(word)
                .category(Edu.determineCategory(word)) // 자동 카테고리 설정
                .videoUrl(videoUrl)
                .views(0)
                .build();
    }
}
