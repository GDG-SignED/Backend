package com.gdg.backendse.controller;

import com.gdg.backendse.domain.Edu;
import com.gdg.backendse.domain.EduCategory;
import com.gdg.backendse.dto.Edu.EduRequestDTO;
import com.gdg.backendse.dto.Edu.EduResponseDTO;
import com.gdg.backendse.service.EduService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/edu")
@RequiredArgsConstructor
public class EduController {
    private final EduService eduService;

    // ✅ 새 Edu 등록 (단어에 따라 자동 분류됨)
    @PostMapping
    public ResponseEntity<EduResponseDTO> createEdu(@RequestBody EduRequestDTO requestDTO) {
        Edu edu = eduService.createEdu(requestDTO);
        return ResponseEntity.ok(new EduResponseDTO(edu));
    }

    // ✅ 카테고리별 Edu 데이터 조회 (String으로 받아 변환)
    @GetMapping
    public ResponseEntity<List<EduResponseDTO>> getEduByCategory(@RequestParam String category) {
        EduCategory eduCategory;
        try {
            eduCategory = EduCategory.valueOf(category.toUpperCase()); // 🔹 카테고리 변환 (소문자 입력 가능)
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build(); // 🔹 잘못된 카테고리 값 처리 (400 Bad Request)
        }

        List<Edu> eduList = eduService.getEduByCategory(eduCategory);
        List<EduResponseDTO> responseDTOList = eduList.stream()
                .map(EduResponseDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseDTOList);
    }

    // ✅ 단어 검색 API
    @PostMapping("/search")
    public ResponseEntity<List<Edu>> searchEduByWord(@RequestBody EduRequestDTO eduRequestDTO) {
        List<Edu> results = eduService.searchByWord(eduRequestDTO.getWord()); // Edu의 word 검색
        return ResponseEntity.ok(results);
    }

    //조회수 증가
    @GetMapping("/{id}")
    public ResponseEntity<Edu> getEdu(@PathVariable Long id) {
        Edu edu = eduService.getEduAndIncrementViews(id);
        return ResponseEntity.ok(edu);
    }

}
