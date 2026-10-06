package com.example.atividadeapi.controller;

import com.example.atividadeapi.entity.CarroEntity;
import com.example.atividadeapi.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/carro")
public class CarroController {
    @Autowired
    private CarroService service;

    @GetMapping
    public List<CarroEntity> listarTodos() {return service.listarTodosCarros();}

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar (@RequestBody CarroEntity carro){
        service.salvarCarro(carro);
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem","Carro cadastrado com sucessso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(@PathVariable Long id, @RequestBody CarroEntity carro){
        service.atualizarCarro(id, carro);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Carro atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id){
        service.excluirCarro(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Carro excluido com sucesso"));
    }
}
