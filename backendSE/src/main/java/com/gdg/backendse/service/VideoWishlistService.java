package com.gdg.backendse.service;

import com.gdg.backendse.domain.LearningVideo;
import com.gdg.backendse.domain.Member;
import com.gdg.backendse.domain.VideoWishlist;
import com.gdg.backendse.dto.Edu.LearningVideoDTO;
import com.gdg.backendse.repository.LearningVideoRepository;
import com.gdg.backendse.repository.UserRepository;
import com.gdg.backendse.repository.VideoWishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VideoWishlistService {
    private final VideoWishlistRepository videoWishlistRepository;
    private final UserRepository memberRepository;
    private final LearningVideoRepository learningVideoRepository;

    // 찜 추가
    public void addWishlist(Long memberId, Long videoId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));
        LearningVideo video = learningVideoRepository.findById(videoId)
                .orElseThrow(() -> new IllegalArgumentException("영상이 존재하지 않습니다."));

        // 중복 찜 방지
        if (videoWishlistRepository.existsByMemberAndVideo(member, video)) {
            throw new IllegalArgumentException("이미 찜한 영상입니다.");
        }

        VideoWishlist wishlist = new VideoWishlist(member, video);
        videoWishlistRepository.save(wishlist);
    }

    // 찜 목록 조회
    public List<LearningVideoDTO> getWishlist(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        List<VideoWishlist> wishlist = videoWishlistRepository.findByMember(member);

        return wishlist.stream()
                .map(vw -> LearningVideoDTO.fromEntity(vw.getVideo())) // DTO 변환 적용
                .collect(Collectors.toList());
    }


    // 찜 삭제
    public void removeWishlist(Long memberId, Long videoId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));
        LearningVideo video = learningVideoRepository.findById(videoId)
                .orElseThrow(() -> new IllegalArgumentException("영상이 존재하지 않습니다."));

        VideoWishlist wishlist = videoWishlistRepository.findByMemberAndVideo(member, video)
                .orElseThrow(() -> new IllegalArgumentException("찜 목록에 존재하지 않는 영상입니다."));
        videoWishlistRepository.delete(wishlist);
    }
}

