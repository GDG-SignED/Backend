package com.gdg.backendse.dto.member;

import com.gdg.backendse.domain.Member;
import com.gdg.backendse.domain.Role;
import com.gdg.backendse.dto.Edu.BookmarkDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class MemberDTO {
    private int memberId;
    private String email;
    private String name;
    private String nickname;
    private String profile;
    private Role role;
    private List<BookmarkDTO> bookmarks;

    // 엔티티 -> DTO 변환
    public MemberDTO(Member member) {
        this.memberId = member.getMemberId();
        this.email = member.getEmail();
        this.name = member.getName();
        this.nickname = member.getNickname();
        this.profile = member.getProfile();
        this.role = member.getRole();
        this.bookmarks = member.getBookmarks().stream()
                .map(bookmark -> new BookmarkDTO(bookmark.getEdu()))
                .collect(Collectors.toList());

    }
}
