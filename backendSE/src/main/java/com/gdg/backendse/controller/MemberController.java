package com.gdg.backendse.controller;

import com.gdg.backendse.domain.Member;
import com.gdg.backendse.service.GoogleLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final GoogleLoginService googleLoginService;

    @GetMapping("/login")
    public Member member(Principal principal){
        if (principal == null) {
            throw new RuntimeException("Principal is null. User is not authenticated.");
        }
        return googleLoginService.test(principal);
    }
}
