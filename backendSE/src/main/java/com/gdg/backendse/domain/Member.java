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

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String email;

    @Column(name = "login_method")
    private String loginMethod;

    @Column(name = "remaining_test")
    private int remainingTest;

    @Column(nullable = false)
    private String profile;

    @Builder
    public Member(int memberId, String name, String nickname, String email,String loginMethod,int remainingTest, String profile){
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.loginMethod = loginMethod;
        this.remainingTest = remainingTest;
        this.nickname = nickname;
        this.profile = profile;
    }
}

