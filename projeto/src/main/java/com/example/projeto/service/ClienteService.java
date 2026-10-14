package com.example.projeto.service;

import com.example.projeto.dto.ClienteRequestDTO;
import com.example.projeto.dto.ClienteResponseDTO;
import com.example.projeto.entity.ClienteEntity;
import com.example.projeto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;


    //READ - GET
    public List<ClienteResponseDTO> listarTodos(){
        return clienteRepository
                .findAll()
                .stream()
                .map(cliente -> new ClienteResponseDTO(
                        cliente.getNome(),
                        cliente.getEmail(),
                        cliente.getTelefone()))
                .toList();

    }

    //insert - post
    public ClienteEntity salvar(ClienteRequestDTO dto){
        if (clienteRepository.findByEmail(dto.getEmail()).isPresent())
            throw new IllegalArgumentException("Cliente já cadastrado");

        ClienteEntity novoCliente = new ClienteEntity();
        novoCliente.setNome(dto.getNome());
        novoCliente.setEmail(dto.getEmail());
        novoCliente.setTelefone(dto.getTelefone());

        return clienteRepository.save(novoCliente);
    }


    public ClienteEntity atualizar(Long id, ClienteRequestDTO dto){
        if (!clienteRepository.existsById(id))
            throw new IllegalArgumentException("Cliente não encontrado");

        ClienteEntity novoCliente = new ClienteEntity();
        novoCliente.setId(id);
        novoCliente.setNome(dto.getNome());
        novoCliente.setEmail(dto.getEmail());
        novoCliente.setTelefone(dto.getTelefone());

        return clienteRepository.save(novoCliente);
    }

    //DELETE - DELETE
    public void excluir(Long id) {
        if (!clienteRepository.existsById(id))
            throw new IllegalArgumentException("cliente não encontrado");

        clienteRepository.deleteById(id);
    }
}
