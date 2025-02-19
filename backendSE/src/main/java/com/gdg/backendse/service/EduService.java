package com.gdg.backendse.service;

import com.gdg.backendse.domain.Edu;
import com.gdg.backendse.domain.EduCategory;
import com.gdg.backendse.dto.Edu.EduRequestDTO;
import com.gdg.backendse.repository.EduRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EduService {
    private final EduRepository eduRepository;

    // Edu 저장 (단어를 기반으로 카테고리 자동 설정)
    @Transactional
    public Edu createEdu(EduRequestDTO requestDTO) {
        EduCategory category = Edu.determineCategory(requestDTO.getWord());

        Edu edu = Edu.builder()
                .title(requestDTO.getTitle())
                .content(requestDTO.getContent())
                .word(requestDTO.getWord())
                .category(category)
                .videoUrl(requestDTO.getVideoUrl())
                .views(0)
                .build();

        return eduRepository.save(edu);
    }

    // 카테고리별 Edu 조회 (Edu 리스트 반환)
    @Transactional
    public List<Edu> getEduByCategory(EduCategory category) {
        return eduRepository.findByCategory(category);
    }

    // 단어로 검색
    @Transactional
    public List<Edu> searchByWord(String word) {
        return eduRepository.findByWordContaining(word);
    }

    @Transactional
    public Edu getEduAndIncrementViews(Long eduId) {
        eduRepository.incrementViews(eduId); // 조회수 증가
        return eduRepository.findById(eduId)
                .orElseThrow(() -> new RuntimeException("교육 정보를 찾을 수 없습니다."));
    }
}
