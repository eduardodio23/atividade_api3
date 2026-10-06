package com.example.atividadeapi.service;

import com.example.atividadeapi.entity.FornecedorEntity;
import com.example.atividadeapi.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public List<FornecedorEntity> listarTodosFornecedores() {
        return repository.findAll();
    }

    public FornecedorEntity salvarFornecedor(FornecedorEntity fornecedor) {
        if (repository.findByCnpj(fornecedor.getCnpj()).isPresent()) {
            throw new IllegalArgumentException("Fornecedor já cadastrado");
        }

        return repository.save(fornecedor);
    }

    public FornecedorEntity atualizarFornecedor(Long id, FornecedorEntity fornecedor) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Fornecedor não encontrado.");
        }

        fornecedor.setId(id);
        return repository.save(fornecedor);
    }

    public void excluirFornecedor(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Fornecedor não encontrado.");
        }

        repository.deleteById(id);
    }
}