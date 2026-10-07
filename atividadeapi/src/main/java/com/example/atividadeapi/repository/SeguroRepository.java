package com.example.atividadeapi.repository;

import com.example.atividadeapi.entity.SeguroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeguroRepository extends JpaRepository<SeguroEntity, Long> {
    Optional<SeguroEntity> findBynumeroApolice(String numeroApolice);
}
