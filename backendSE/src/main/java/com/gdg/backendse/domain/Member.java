package com.gdg.backendse.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING) // Enum 값을 문자열로 DB에 저장
    @Column(name = "login_method", nullable = false)
    private LoginMethod loginMethod;

    @Column(name = "remaining_test")
    private int remainingTest;

    @Column(nullable = false)
    private String profile;

    @Builder
    public Member(String name, String nickname, String email, LoginMethod loginMethod,int remainingTest, String profile){
        this.name = name;
        this.email = email;
        this.loginMethod = loginMethod;
        this.remainingTest = remainingTest;
        this.nickname = nickname;
        this.profile = profile;
    }
}

