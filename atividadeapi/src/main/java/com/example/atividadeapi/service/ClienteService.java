package com.example.atividadeapi.service;


import com.example.atividadeapi.entity.ClienteEntity;
import com.example.atividadeapi.entity.FornecedorEntity;
import com.example.atividadeapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;
    public List<ClienteEntity> ListartodoosClientes() {return repository.findAll(); }
    public ClienteEntity salvarcliente(ClienteEntity cliente) {
        if (repository.findBycpf(cliente.getCpf()).isPresent()) {
            throw new IllegalArgumentException("Cliente Cadastrado com Sucesso");
        }

        return repository.save(cliente);

}
    public ClienteEntity atualizarCliente(Long id, ClienteEntity cliente) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não Encontrado.");
        }

        cliente.setId(id);
        return repository.save(cliente);
    }

    public void excluirCliente(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não Encontrado.");
        }

        repository.deleteById(id);
    }
}