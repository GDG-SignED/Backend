package com.gdg.backendse.repository;

import com.gdg.backendse.domain.Bookmark;
import com.gdg.backendse.domain.Edu;
import com.gdg.backendse.domain.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findByMember(Member member);
    boolean existsByMemberAndEdu(Member member, Edu edu);
    void deleteByMemberAndEdu(Member member, Edu edu);

    @Transactional
    @Modifying
    @Query("DELETE FROM Bookmark b WHERE b.member.memberId = :memberId")
    void deleteByMemberId(@Param("memberId") int memberId);
}
