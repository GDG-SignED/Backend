package com.gdg.backendse.repository;

import com.gdg.backendse.domain.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findById(Integer userId);

    Optional<Member> findByEmail(String email);

    @Modifying
    @Transactional
    @Query("DELETE FROM Member m WHERE m.memberId = :memberId")
    void deleteById(@Param("memberId") int memberId);

}

