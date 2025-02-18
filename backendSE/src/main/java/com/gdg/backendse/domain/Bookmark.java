package com.gdg.backendse.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member; // 북마크한 회원

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edu_id", nullable = false)
    private Edu edu; // 북마크한 교육 정보

    @Builder
    public Bookmark(Member member, Edu edu) {
        this.member = member;
        this.edu = edu;
    }
}
