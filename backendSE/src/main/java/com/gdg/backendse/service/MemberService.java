package com.gdg.backendse.service;

import com.gdg.backendse.domain.Bookmark;
import com.gdg.backendse.domain.Member;
import com.gdg.backendse.dto.CorrectCountUpdateRequest;
import com.gdg.backendse.dto.Edu.BookmarkDTO;
import com.gdg.backendse.dto.member.UserProfileResponseDTO;
import com.gdg.backendse.dto.member.UserUpdateProfileRequestDTO;
import com.gdg.backendse.repository.BookmarkRepository;
import com.gdg.backendse.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BookmarkRepository bookmarkRepository;

    @Transactional
    public void updateCorrectCount(CorrectCountUpdateRequest request) {
        System.out.println("✅ 요청 받은 memberId: " + request.getMemberId());  // 로그 추가

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> {
                    System.err.println("❌ Member ID " + request.getMemberId() + "가 존재하지 않음!");
                    return new IllegalArgumentException("Member not found with ID: " + request.getMemberId());
                });

        System.out.println("✅ 기존 맞춘 문제 개수: " + member.getCorrectCount());

        member.incrementCorrectCount(); // ✅ 맞춘 문제 개수 증가
        System.out.println("✅ 업데이트된 맞춘 문제 개수: " + member.getCorrectCount());
    }

    // 회원 프로필 조회
    public UserProfileResponseDTO getUserProfile(Integer userId) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        // 북마크 목록 조회
        List<BookmarkDTO> bookmarkDTOs = bookmarkRepository.findByMember(member)
                .stream()
                .map(bookmark -> BookmarkDTO.from(bookmark.getEdu())) // Edu → BookmarkDTO 변환
                .collect(Collectors.toList());

        // 테스트 결과 목록 조회

        return new UserProfileResponseDTO(member, bookmarkDTOs );
    }

    // 닉네임 변경
    @Transactional
    public void updateUserNickname(Integer userId, UserUpdateProfileRequestDTO requestDto) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        member.updateNickname(requestDto.getNickname());
    }

//    // 이메일로 회원 정보 조회
//    public Member findByEmail(String email) {
//        return userRepository.findByEmail((email)
//                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다.")));
//
//    }

    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
    }

    // 회원 삭제 (탈퇴)
    @Transactional
    public void deleteUserById(int memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isEmpty()) {
            throw new RuntimeException("사용자를 찾을 수 없습니다: " + memberId);
        }

        System.out.println(" 회원 삭제 진행 중 - ID: " + memberId);

        // 북마크 먼저 삭제
        bookmarkRepository.deleteByMemberId(memberId);

        // 회원 삭제
        memberRepository.deleteById(memberId);

        System.out.println(" 회원 삭제 완료 - ID: " + memberId);
    }

}
