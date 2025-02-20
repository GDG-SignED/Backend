package com.gdg.backendse.controller;

import com.gdg.backendse.dto.login.GoogleTokenDto;
import com.gdg.backendse.dto.login.GoogleLoginRequest;
import com.gdg.backendse.service.GoogleLoginService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

    private final GoogleLoginService googleLoginService;

    @PostMapping("/google")
    public GoogleTokenDto googleLogin(@RequestBody GoogleLoginRequest request) {
        log.info("Google OAuth 인증 코드: {}", request.getCode());

        // Google Access Token 요청
        String googleAccessToken = googleLoginService.getGoogleAccessToken(request.getCode());

        // ✅ 오류 수정: request.getCode() 사용
        System.out.println("Received Google auth code: " + request.getCode());

        // 로그인/회원가입 처리 후 Access Token 반환
        return googleLoginService.loginOrSignUp(googleAccessToken);
    }
}
