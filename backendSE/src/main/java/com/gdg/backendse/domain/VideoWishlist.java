package com.gdg.backendse.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class VideoWishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // 찜한 회원

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "learning_video_id")
    private LearningVideo video; // 찜한 학습 영상

    @Builder
    public VideoWishlist(Member member, LearningVideo video) {
        this.member = member;
        this.video = video;
    }
}

