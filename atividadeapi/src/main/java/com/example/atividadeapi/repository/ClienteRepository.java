package com.example.atividadeapi.repository;


import com.example.atividadeapi.entity.ClienteEntity;
import com.example.atividadeapi.entity.FornecedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    Optional<FornecedorEntity> findBycpf(String cpf);

}
