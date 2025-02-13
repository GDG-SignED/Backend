package com.gdg.backendse.dto.Edu;

import com.gdg.backendse.domain.Member;
import com.gdg.backendse.domain.SignWord;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignWordResponseDTO {
    private String word;
    private String definition;
    private String imageUrl;
    private String videoUrl;

    public static SignWordResponseDTO from(SignWord signWord) {
        return SignWordResponseDTO.builder()
                .word(signWord.getWord())
                .definition(signWord.getDefinition())
                .imageUrl(signWord.getImageUrl())
                .videoUrl(signWord.getVideoUrl())
                .build();
    }
}
