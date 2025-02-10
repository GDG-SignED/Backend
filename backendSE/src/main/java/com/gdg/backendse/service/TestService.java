package com.gdg.backendse.service;

import com.gdg.backendse.domain.Test;
import com.gdg.backendse.domain.Member;
import com.gdg.backendse.repository.TestRepository;
import com.gdg.backendse.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public boolean saveTestResult(int memberId, String answer) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isEmpty()) {
            return false; // 없는 회원이면 저장 안 함
        }

        // 정답 데이터 저장
        Test test = Test.builder()
                .testContent(answer)
                .answerImage("placeholder.png") // 정답 이미지는 AI가 제공하는 방식에 따라 변경 가능
                .build();

        testRepository.save(test);
        return true;
    }
}
