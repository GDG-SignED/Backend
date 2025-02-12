package com.gdg.backendse.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;

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

//    //검색어 기능을 위해 추가할 사항
//    @OneToMany(mappedBy = "edu", fetch = FetchType.LAZY)
//    private List<SearchKeyword> searchKeywords = new ArrayList<>();

    @Builder
    public Edu(String title, String content, int views, String imagePath, String videoPath, List<Bookmark> bookmarks, List<SignWord> searchKeyword) {
        this.title = title;
        this.content = content;
        this.views = views;
        this.videoPath = videoPath;
        this.bookmarks = bookmarks;
//        this.searchKeywords = searchKeyword;
    }
}
