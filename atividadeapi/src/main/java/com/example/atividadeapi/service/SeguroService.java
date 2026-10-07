package com.example.atividadeapi.service;

import com.example.atividadeapi.entity.SeguroEntity;
import com.example.atividadeapi.repository.SeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeguroService {
    @Autowired
    private SeguroRepository repository;

    public List<SeguroEntity> listarTodosSeguros(){ return  repository.findAll();}

    public SeguroEntity salvarSeguro(SeguroEntity seguro){
        if (repository.findBynumeroApolice(seguro.getNumeroApolice()).isPresent()){
            throw new IllegalArgumentException("Seguro já cadastrado");
        }

        return repository.save(seguro);
    }

    public SeguroEntity atualizarSeguro(Long id, SeguroEntity seguro){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Seguro não encontrado");
        }

        seguro.setId(id);
        return repository.save(seguro);
    }

    public void excluirSeguro(Long id){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Seguro não encontrado.");
        }

        repository.deleteById(id);
    }
}
