package com.example.atividadeapi.repository;

import com.example.atividadeapi.entity.MotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotoRepository extends JpaRepository<MotoEntity, Long> {
    Optional<MotoEntity> findBymodelo(String modelo);
}
