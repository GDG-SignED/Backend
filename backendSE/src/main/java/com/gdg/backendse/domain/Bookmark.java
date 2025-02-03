package com.gdg.backendse.domain;

import jakarta.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookmark_id")
    private int bookmarkId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edu_id")
    private Edu edu;

    @Builder
    public Bookmark(int bookmarkId, Member member, Edu edu) {
        this.member = member;
        this.edu = edu;
    }
}
