package com.gdg.backendse.controller;

import com.gdg.backendse.domain.LearningVideo;
import com.gdg.backendse.service.VideoWishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
@RequiredArgsConstructor
public class VideoWishlistController {
    private final VideoWishlistService videoWishlistService;

    // 찜 추가
    @PostMapping("/{memberId}/{videoId}")
    public ResponseEntity<?> addWishlist(@PathVariable Long memberId, @PathVariable Long videoId) {
        videoWishlistService.addWishlist(memberId, videoId);
        return ResponseEntity.ok("찜 목록에 추가되었습니다.");
    }

    // 찜 목록 조회
    @GetMapping("/{memberId}")
    public ResponseEntity<?> getWishlist(@PathVariable Long memberId) {
        List<LearningVideo> wishlist = videoWishlistService.getWishlist(memberId);
        return ResponseEntity.ok(wishlist);
    }

    // 찜 삭제
    @DeleteMapping("/{memberId}/{videoId}")
    public ResponseEntity<?> removeWishlist(@PathVariable Long memberId, @PathVariable Long videoId) {
        videoWishlistService.removeWishlist(memberId, videoId);
        return ResponseEntity.ok("찜 목록에서 삭제되었습니다.");
    }
}

