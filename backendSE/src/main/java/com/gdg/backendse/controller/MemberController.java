package com.gdg.backendse.controller;

import com.gdg.backendse.domain.Member;
import com.gdg.backendse.dto.CorrectCountUpdateRequest;
import com.gdg.backendse.dto.member.MemberDTO;
import com.gdg.backendse.dto.member.UserProfileResponseDTO;
import com.gdg.backendse.dto.member.UserUpdateProfileRequestDTO;
import com.gdg.backendse.service.GoogleLoginService;
import com.gdg.backendse.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final GoogleLoginService googleLoginService;
    private final MemberService memberService;

    @GetMapping("/login")
    public ResponseEntity<MemberDTO> getMember(Principal principal){
        if (principal == null) {
            throw new RuntimeException("Principal is null. User is not authenticated.");
        }

        Member member = googleLoginService.test(principal);
        return ResponseEntity.ok(new MemberDTO(member));
    }

    // 맞춘 문제 개수 업데이트 API
    @PostMapping("/correct-count")
    public ResponseEntity<String> updateCorrectCount(@RequestBody CorrectCountUpdateRequest request) {
        memberService.updateCorrectCount(request);
        return ResponseEntity.ok("Correct count updated successfully!");
    }

    // 회원 프로필 조회
    @GetMapping("/profile/{memberId}")
    public ResponseEntity<UserProfileResponseDTO> getUserProfile(@PathVariable Integer memberId) {
        UserProfileResponseDTO userProfile = memberService.getUserProfile(memberId);
        return ResponseEntity.ok(userProfile);
    }

    // 닉네임 변경
    @PutMapping("/profileEdit/{memberId}")
    public ResponseEntity<String> editUserNickname(@PathVariable Integer memberId, @RequestBody UserUpdateProfileRequestDTO requestDto) {
        memberService.updateUserNickname(memberId, requestDto);
        return ResponseEntity.ok("Nickname updated for user ID: " + memberId);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(401).body("로그인 상태가 아닙니다.");
        }

        // Principal이 ID 값(String)인지 확인
        Object principal = authentication.getPrincipal();
        System.out.println(" [컨트롤러] Principal: " + principal);

        if (!(principal instanceof String)) {
            return ResponseEntity.status(403).body("잘못된 인증 객체입니다: " + principal);
        }

        int memberId = Integer.parseInt((String) principal); // ID 값 변환
        System.out.println(" [컨트롤러] 회원 삭제 요청 - ID: " + memberId);

        memberService.deleteUserById(memberId);  // ID 값으로 삭제

        return ResponseEntity.ok("회원 탈퇴가 완료되었습니다.");
    }

}
