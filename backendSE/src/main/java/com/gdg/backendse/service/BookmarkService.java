package com.gdg.backendse.service;

import com.gdg.backendse.domain.Bookmark;
import com.gdg.backendse.domain.Edu;
import com.gdg.backendse.domain.Member;
import com.gdg.backendse.dto.Edu.BookmarkDTO;
import com.gdg.backendse.repository.BookmarkRepository;
import com.gdg.backendse.repository.EduRepository;
import com.gdg.backendse.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
    private final EduRepository eduRepository;
    private final MemberRepository memberRepository;

    // 사용자가 특정 Edu를 찜하기 (중복 방지)
    @Transactional
    public void addBookmark(int memberId, Long eduId) {
        System.out.println("🔍 memberId: " + memberId + ", eduId: " + eduId); // 로그 추가
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다."));

        Edu edu = eduRepository.findById(eduId)
                .orElseThrow(() -> new IllegalArgumentException("해당 학습 영상을 찾을 수 없습니다."));

        if (bookmarkRepository.existsByMemberAndEdu(member, edu)) {
            throw new IllegalStateException("이미 찜한 Edu입니다.");
        }

        Bookmark bookmark = new Bookmark(member, edu);
        bookmarkRepository.save(bookmark);
    }

    // 사용자가 특정 Edu 찜 해제하기
    @Transactional
    public void removeBookmark(int memberId, Long eduId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다."));

        Edu edu = eduRepository.findById(eduId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Edu를 찾을 수 없습니다."));

        bookmarkRepository.deleteByMemberAndEdu(member, edu);
    }

    // 사용자가 찜한 Edu 목록 조회 → List<BookmarkDTO> 반환
    @Transactional
    public List<BookmarkDTO> getUserBookmarks(int memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다."));

        return bookmarkRepository.findByMember(member).stream()
                .map(bookmark -> BookmarkDTO.from(bookmark.getEdu()))
                .collect(Collectors.toList());
    }
}
