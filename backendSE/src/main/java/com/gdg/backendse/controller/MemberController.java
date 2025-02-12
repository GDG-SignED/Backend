package com.gdg.backendse.controller;

import com.gdg.backendse.domain.Member;
import com.gdg.backendse.dto.CorrectCountUpdateRequest;
import com.gdg.backendse.service.GoogleLoginService;
import com.gdg.backendse.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final GoogleLoginService googleLoginService;
    private final MemberService memberService;

    // Google 로그인 테스트용 API
    @GetMapping("/test")
    public Member member(Principal principal) {
        return googleLoginService.test(principal);
    }

    // 맞춘 문제 개수 업데이트 API
    @PostMapping("/correct-count")
    public ResponseEntity<String> updateCorrectCount(@RequestBody CorrectCountUpdateRequest request) {
        memberService.updateCorrectCount(request);
        return ResponseEntity.ok("Correct count updated successfully!");
    }
}
