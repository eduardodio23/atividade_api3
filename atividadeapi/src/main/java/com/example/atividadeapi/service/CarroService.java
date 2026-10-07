package com.example.atividadeapi.service;

import com.example.atividadeapi.entity.CarroEntity;
import com.example.atividadeapi.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public List<CarroEntity> listarTodosCarros(){ return repository.findAll(); }

    public CarroEntity salvarCarro(CarroEntity carro){
        if (repository.findBymodelo(carro.getModelo()).isPresent()){
            throw new IllegalArgumentException("Carro já cadastrado");
        }

        return repository.save(carro);
    }

    public CarroEntity atualizarCarro(Long id, CarroEntity  carro){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Carro não encontrado");
        }

        carro.setId(id);
        return repository.save(carro);
    }

    public void excluirCarro(Long id){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Carro não encontrado.");
        }

        repository.deleteById(id);
    }
}
