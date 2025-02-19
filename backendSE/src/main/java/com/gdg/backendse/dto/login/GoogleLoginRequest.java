package com.gdg.backendse.dto.login;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GoogleLoginRequest {
    private String code; // 프론트에서 전달받을 Google Authorization Code
}

