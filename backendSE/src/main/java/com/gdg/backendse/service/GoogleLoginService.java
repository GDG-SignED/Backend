package com.gdg.backendse.service;

import com.gdg.backendse.domain.Member;
import com.gdg.backendse.domain.Role;
import com.gdg.backendse.dto.login.GoogleTokenDto;
import com.gdg.backendse.dto.member.UserInfo;
import com.gdg.backendse.jwt.TokenProvider;
import com.gdg.backendse.repository.MemberRepository;
import com.gdg.backendse.util.NicknameGenerator;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.security.Principal;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GoogleLoginService {

    private final String GOOGLE_TOKEN_URL = "https://oauth2.googleapis.com/token";
    @Value("${google.client.id}")
    private String GOOGLE_CLIENT_ID;

    @Value("${google.client.secret}")
    private String GOOGLE_CLIENT_SECRET;
    //프론트 연결시 사용
    private final String GOOGLE_REDIRECT_URI = "http://localhost:5173/login-handler";
    //private final String GOOGLE_REDIRECT_URI = "http://localhost:8080/api/login/google";

    private final MemberRepository userRepository;
    private final TokenProvider tokenProvider;

    public String getGoogleAccessToken(String code) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = Map.of(
                "code", code,
                "scope", "https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email",
                "client_id", GOOGLE_CLIENT_ID,
                "client_secret", GOOGLE_CLIENT_SECRET,
                "redirect_uri", GOOGLE_REDIRECT_URI,
                "grant_type", "authorization_code"
        );

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(GOOGLE_TOKEN_URL, params, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String json = responseEntity.getBody();
            Gson gson = new Gson();

            return gson.fromJson(json, GoogleTokenDto.class)
                    .getAccessToken();
        }

        throw new RuntimeException("구글 엑세스 토큰을 가져오는데 실패했습니다.");
    }

    public GoogleTokenDto loginOrSignUp(String googleAccessToken) {
        UserInfo userInfo = getUserInfo(googleAccessToken);

        if (!userInfo.getVerifiedEmail()) {
            throw new RuntimeException("이메일 인증이 되지 않은 유저입니다.");
        }

        Member user = userRepository.findByEmail(userInfo.getEmail())
                .map(member -> { // 기존 회원이면 토큰 업데이트
                    member.updateGoogleAccessToken(googleAccessToken);
                    return userRepository.save(member);
                })
                .orElseGet(() -> userRepository.save(Member.builder()
                        .email(userInfo.getEmail())
                        .name(userInfo.getName())
                        .profile(userInfo.getPictureUrl())
                        .nickname(NicknameGenerator.generateRandomNickname())
                        .role(Role.ROLE_USER)
                        .googleAccessToken(googleAccessToken)
                        .build())
                );

        return GoogleTokenDto.builder()
                .accessToken(tokenProvider.createAccessToken(user))
                .build();
    }

    private UserInfo getUserInfo(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.googleapis.com/oauth2/v2/userinfo?access_token=" + accessToken;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, URI.create(url));
        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String json = responseEntity.getBody();
            Gson gson = new Gson();
            return gson.fromJson(json, UserInfo.class);
        }

        throw new RuntimeException("유저 정보를 가져오는데 실패했습니다.");
    }

    public Member test(Principal principal) {
        int id = Integer.parseInt(principal.getName());

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));
    }

//    private final RestTemplate restTemplate = new RestTemplate();
//
//    // 구글 OAuth2 토큰 무효화 메서드 추가
//    public void revokeGoogleToken(String accessToken) {
//        if (accessToken == null || accessToken.isEmpty()) {
//            return; // 저장된 토큰이 없으면 무효화할 필요 없음
//        }
//
//        String revokeUrl = "https://oauth2.googleapis.com/revoke?token=" + accessToken;
//        restTemplate.postForEntity(revokeUrl, null, String.class);
//    }
}
