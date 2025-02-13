package com.gdg.backendse.dto.Edu;

import com.gdg.backendse.domain.SignWord;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignWordRequestDTO {
    private String word;

    public SignWord toEntity(){
        return SignWord.builder()
                .word(word)
                .build();
    }
}
