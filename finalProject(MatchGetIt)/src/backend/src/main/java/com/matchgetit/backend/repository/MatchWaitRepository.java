package com.matchgetit.backend.repository;

import com.matchgetit.backend.entity.MatchWaitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchWaitRepository extends JpaRepository<MatchWaitEntity, Long> {

}
