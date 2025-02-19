package com.gdg.backendse.repository;

import com.gdg.backendse.domain.Edu;
import com.gdg.backendse.domain.EduCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EduRepository extends JpaRepository<Edu, Long> {
    List<Edu> findByCategory(EduCategory category);

    // 특정 단어 포함 검색
    List<Edu> findByWordContaining(String word);

    @Modifying
    @Transactional
    @Query("UPDATE Edu e SET e.views = e.views + 1 WHERE e.id = :eduId")
    void incrementViews(@Param("eduId") Long eduId);
}
