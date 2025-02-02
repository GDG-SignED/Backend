package com.gdg.backendse.controller;

import com.gdg.backendse.dto.login.GoogleTokenDto;
import com.gdg.backendse.service.GoogleLoginService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping("/api")
@Slf4j
public class AuthController {

    private final GoogleLoginService googleLoginService;

    @GetMapping("/login/google")
    public GoogleTokenDto googleCallback(@RequestParam(name = "code") String code) {
        log.info("code -{}" , code);
        String googleAccessToken = googleLoginService.getGoogleAccessToken(code);
        return loginOrSignup(googleAccessToken);
    }

    private GoogleTokenDto loginOrSignup(String googleAccessToken) {
        return googleLoginService.loginOrSignUp(googleAccessToken);
    }
}
