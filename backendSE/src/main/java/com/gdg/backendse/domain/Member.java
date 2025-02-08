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
    private int memberId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING) // Enum 값을 문자열로 DB에 저장
    @Column(name = "login_method")
    private LoginMethod loginMethod;

    @Column(name = "remaining_tests")
    private int remainingTest;

    //맞춘 테스트 개수
    @Column(name = "test_correct_count", nullable = false)
    private int testCorrectCount = 0;

    private String profile;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY) //회원:댓글_일대다
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY) //회원:검색어_일대다
    private List<SearchKeyword> searchKeywords = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY) //회원:퀴즈_일대다
    private List<Test> tests = new ArrayList<>();

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY) //회원:게시글_일대다
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY) // 회원:북마크_일대다
    private List<Bookmark> bookmarks = new ArrayList<>();

    @Builder
    public Member(String name, String nickname, String email, LoginMethod loginMethod,int remainingTest, String profile, Role role){
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.loginMethod = loginMethod;
        this.remainingTest = remainingTest;
        this.testCorrectCount = testCorrectCount;
        this.profile = profile;
        this.role = role;
    }
    // 사용자가 정답을 맞힐 때 호출하는 메서드
    public void increaseCorrectCount() {
        this.testCorrectCount++;
    }

    // 테스트 이용권 차감 메서드 (필요하면 추가)
    public void useTest() {
        if (this.remainingTest > 0) {
            this.remainingTest--;
        } else {
            throw new IllegalStateException("테스트 이용권이 부족합니다.");
        }
    }

//    public boolean isGoogleLogin() {
//        return this.loginMethod == LoginMethod.GOOGLE;
//    }
}

