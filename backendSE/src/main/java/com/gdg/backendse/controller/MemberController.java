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

    @GetMapping("/login")
    public Member member(Principal principal){
        if (principal == null) {
            throw new RuntimeException("Principal is null. User is not authenticated.");
        }
        return googleLoginService.test(principal);
    }

    // 맞춘 문제 개수 업데이트 API
    @PostMapping("/correct-count")
    public ResponseEntity<String> updateCorrectCount(@RequestBody CorrectCountUpdateRequest request) {
        memberService.updateCorrectCount(request);
        return ResponseEntity.ok("Correct count updated successfully!");
    }
}
