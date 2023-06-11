package com.dndappbackend.repository;

import com.dndappbackend.entity.Npc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NpcRepository extends JpaRepository<Npc, Long> {
}
