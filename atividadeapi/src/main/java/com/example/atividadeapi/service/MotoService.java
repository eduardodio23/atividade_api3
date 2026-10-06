package com.example.atividadeapi.service;

import com.example.atividadeapi.entity.MotoEntity;
import com.example.atividadeapi.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {
    @Autowired
    private MotoRepository repository;

    public List<MotoEntity> listarTodasMotos() {return repository.findAll();}

    public MotoEntity salvarMoto(MotoEntity moto){
        if (repository.findBymodelo(moto.getModelo()).isPresent())
            throw new IllegalArgumentException("moto já registrada");

        return repository.save(moto);
    }

    public MotoEntity atualizarMoto(Long id, MotoEntity moto){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Moto não encontrado");
        }

        moto.setId(id);
        return repository.save(moto);
    }

    public void deletarMoto(Long id){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Moto não encontrada");
        }

        repository.deleteById(id);
    }
}
