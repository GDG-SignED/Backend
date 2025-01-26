package com.gdg.backendse.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;

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

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY) //회원:검색어_일대다
    private List<SearchKeyword> searchKeywords = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY) //회원:퀴즈_일대다
    private List<Quiz> quizzes = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY) //회원:클래스(edu)_일대다
    private List<Edu> edus = new ArrayList<>();

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY) //회원:게시글_일대다
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY) //회원:댓글_일대다
    private List<Comment> comments = new ArrayList<>();

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

