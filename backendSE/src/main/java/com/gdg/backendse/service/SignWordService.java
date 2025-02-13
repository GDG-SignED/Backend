package com.gdg.backendse.service;

import com.gdg.backendse.domain.SignWord;
import com.gdg.backendse.dto.Edu.SignWordRequestDTO;
import com.gdg.backendse.dto.Edu.SignWordResponseDTO;
import com.gdg.backendse.repository.SignWordRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SignWordService {
    private final SignWordRepository signWordRepository;

    @Transactional
    public List<SignWordResponseDTO> findByWord(String keyword) {
        List<SignWord> signWords = signWordRepository.findByWord(keyword);

        return signWords.stream()
                .map(SignWordResponseDTO::from)
                .collect(Collectors.toList());
    }
//    public SignWordService(SignWordRepository signWordRepository) {
//        this.signWordRepository = signWordRepository;
//    }
//
//    public List<SignWordResponseDTO> searchSignWord(String keyword) {
//        List<SignWord> words = signWordRepository.findByWordContaining((keyword);
//
//        return words.stream()
//                .map(word -> new SignWordResponseDTO(
//                        word.getWord(),
//                        word.getDefinition(),
//                        word.getImageUrl(),
//                        word.getVideoUrl()))
//                .collect(Collectors.toList());
//    }
}
