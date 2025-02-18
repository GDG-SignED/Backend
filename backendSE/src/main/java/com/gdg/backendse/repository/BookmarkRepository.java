package com.gdg.backendse.repository;

import com.gdg.backendse.domain.Bookmark;
import com.gdg.backendse.domain.Edu;
import com.gdg.backendse.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findByMember(Member member);
    Optional<Bookmark> findByMemberAndEdu(Member member, Edu edu);
    boolean existsByMemberAndEdu(Member member, Edu edu);
    void deleteByMemberAndEdu(Member member, Edu edu);
}
