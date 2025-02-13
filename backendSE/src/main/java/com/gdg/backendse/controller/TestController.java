package com.gdg.backendse.controller;

import com.gdg.backendse.domain.Test;
import com.gdg.backendse.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    // 1️⃣ 테스트 페이지 띄우기
    @GetMapping("/start")
    public String showTestPage(Model model) {
        // 정적 페이지 제공 (src/main/resources/templates/test.html 사용)
        return "test";
    }

    // 2️⃣ 테스트 결과 저장 API
    @PostMapping("/submit")
    public ResponseEntity<String> submitTestResult(@RequestParam int memberId, @RequestParam String answer) {
        boolean isCorrect = testService.saveTestResult(memberId, answer);
        if (isCorrect) {
            return ResponseEntity.ok("정답입니다!");
        } else {
            return ResponseEntity.ok("틀렸습니다! 다시 시도하세요.");
        }
    }
}
