package com.gdg.backendse.controller;

import com.gdg.backendse.dto.Edu.SignWordRequestDTO;
import com.gdg.backendse.dto.Edu.SignWordResponseDTO;
import com.gdg.backendse.service.SignWordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/edu")
public class SignWordController {
    private final SignWordService signWordService;

    public SignWordController(SignWordService signWordService) {
        this.signWordService = signWordService;
    }

    @PostMapping("/search")
    public ResponseEntity<?> findByWord(@RequestBody SignWordRequestDTO signWordRequestDTO) {
        if (signWordRequestDTO.getWord() == null || signWordRequestDTO.getWord().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("검색어를 입력해주세요.");
        }

        List<SignWordResponseDTO> results = signWordService.findByWord(signWordRequestDTO.getWord());

        if (results.isEmpty()) {
            return ResponseEntity.ok("존재하지 않는 단어입니다.");
        }

        return ResponseEntity.ok(results);
    }

}
