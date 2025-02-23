package com.gdg.backendse.dto.member;

import com.gdg.backendse.domain.Member;
import com.gdg.backendse.dto.Edu.BookmarkDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class UserProfileResponseDTO {
    private String name;
    private String nickname;
    private String profile;
    private String email;
    //private List<TestResultDTO> testResults;  // 추가
    private List<BookmarkDTO> bookmarks; // 추가

    //TestResultDTO 추가하면 여기에서도 추가해줘야함. List<TestResultDTO> testResults
    public UserProfileResponseDTO(Member member, List<BookmarkDTO> bookmarks) {
        this.name = member.getName();
        this.nickname = member.getNickname();
        this.profile = member.getProfile();
        this.email = member.getEmail();
        //this.testResults = testResults;
        this.bookmarks = bookmarks;
    }
}
