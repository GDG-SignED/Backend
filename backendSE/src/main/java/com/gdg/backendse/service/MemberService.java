package com.gdg.backendse.service;

import com.gdg.backendse.domain.Member;
import com.gdg.backendse.dto.CorrectCountUpdateRequest;
import com.gdg.backendse.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

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
}
