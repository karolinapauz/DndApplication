package com.dndappbackend.repository;

import com.dndappbackend.entity.PlayableChar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharRepository extends JpaRepository<PlayableChar, Long> {
}
