package com.gdg.backendse.repository;

import com.gdg.backendse.domain.LearningVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningVideoRepository extends JpaRepository<LearningVideo, Long> {
}
