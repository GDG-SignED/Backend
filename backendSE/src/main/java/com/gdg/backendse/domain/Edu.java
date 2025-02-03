package com.gdg.backendse.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Edu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edu_id")
    private int eduId;

    @Column(name = "edu_title", nullable = false)
    private String title;

    @Column(name = "edu_content", nullable = false)
    private String content; //내용

    @Column(nullable = false)
    private int views; //조회수

    @Column(name = "video_path")
    private String videoPath;

    @OneToMany(mappedBy = "edu", fetch = FetchType.LAZY) // Edu 콘텐츠:북마크_일대다
    private List<Bookmark> bookmarks = new ArrayList<>();


    @Builder
    public Edu(Long eduId, String title, String content, int views, String imagePath, String videoPath) {
        this.title = title;
        this.content = content;
        this.views = views;
        this.videoPath = videoPath;
    }
}
