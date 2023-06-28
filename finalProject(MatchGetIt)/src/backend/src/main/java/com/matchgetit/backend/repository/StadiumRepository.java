package com.matchgetit.backend.repository;

import com.matchgetit.backend.entity.StadiumEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StadiumRepository extends JpaRepository<StadiumEntity,Integer> {
    @Transactional
    List<StadiumEntity> findAll();
}
