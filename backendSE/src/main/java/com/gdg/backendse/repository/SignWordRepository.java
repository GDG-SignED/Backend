package com.gdg.backendse.repository;

import com.gdg.backendse.domain.SignWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SignWordRepository extends JpaRepository<SignWord, Integer> {
    List<SignWord> findByWord(String word);

    Optional<SignWord> findByWordContaining(String word);
}
