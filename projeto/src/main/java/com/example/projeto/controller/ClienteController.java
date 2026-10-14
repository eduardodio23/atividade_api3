package com.example.projeto.controller;

import com.example.projeto.dto.ClienteRequestDTO;
import com.example.projeto.dto.ClienteResponseDTO;
import com.example.projeto.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarTodos(){
        return ResponseEntity
                .ok()
                .body(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Map<?,?>> salvar(@Valid @RequestBody ClienteRequestDTO dto){
        service.salvar(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "cliente salvo com sucesso"));
    }

    @PutMapping
    public ResponseEntity<Map<?,?>> atualizr (@PathVariable Long id, @Valid @RequestBody ClienteRequestDTO dto){
        service.atualizar(id, dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "cliente atualizado com sucesso"));
    }

    @DeleteMapping
    public ResponseEntity<Map<?, ?>> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "cliente removido com sucesso"));
    }
}
