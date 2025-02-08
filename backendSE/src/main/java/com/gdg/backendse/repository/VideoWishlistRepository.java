package com.gdg.backendse.repository;

import com.gdg.backendse.domain.LearningVideo;
import com.gdg.backendse.domain.Member;
import com.gdg.backendse.domain.VideoWishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoWishlistRepository extends JpaRepository<VideoWishlist, Long> {
    // 특정 회원이 특정 영상을 이미 찜했는지 확인
    boolean existsByMemberAndVideo(Member member, LearningVideo video);

    // 특정 회원의 찜 목록 가져오기
    List<VideoWishlist> findByMember(Member member);

    Optional<VideoWishlist> findByMemberAndVideo(Member member, LearningVideo video);
}
