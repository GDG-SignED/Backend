package com.gdg.backendse.controller;

import com.gdg.backendse.dto.Edu.BookmarkDTO;
import com.gdg.backendse.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/bookmark")
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService bookmarkService;

    // Edu 찜하기
    @PostMapping("/{memberId}/{eduId}")
    public ResponseEntity<String> addBookmark(@PathVariable int memberId, @PathVariable Long eduId) {
        log.info(" memberId: {}, eduId: {}", memberId, eduId);
        bookmarkService.addBookmark(memberId, eduId);
        return ResponseEntity.ok("찜 목록에 추가되었습니다.");
    }

    // Edu 찜 해제하기
    @DeleteMapping("/{memberId}/{eduId}")
    public ResponseEntity<?> removeBookmark(@PathVariable int memberId, @PathVariable Long eduId) {
        bookmarkService.removeBookmark(memberId, eduId);
        return ResponseEntity.ok("찜 목록에서 삭제되었습니다.");
    }

    // 사용자가 찜한 Edu 목록 조회
    @GetMapping("/{memberId}")
    public ResponseEntity<List<BookmarkDTO>> getUserBookmarks(@PathVariable int memberId) {
        List<BookmarkDTO> bookmarks = bookmarkService.getUserBookmarks(memberId);
        return ResponseEntity.ok(bookmarks);
    }
}
