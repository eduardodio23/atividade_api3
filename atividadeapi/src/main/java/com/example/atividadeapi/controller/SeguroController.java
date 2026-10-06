package com.example.atividadeapi.controller;

import com.example.atividadeapi.entity.SeguroEntity;
import com.example.atividadeapi.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/seguro")
public class SeguroController {
    @Autowired
    private SeguroService service;

    @GetMapping
    public List<SeguroEntity> listarTodos() {return service.listarTodosSeguros();}

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar (@RequestBody SeguroEntity seguro){
        service.salvarSeguro(seguro);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "seguro cadastrado com sucesso"));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(@PathVariable Long id, @RequestBody SeguroEntity seguro){
        service.atualizarSeguro(id, seguro);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "seguro atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletar(@PathVariable Long id){
        service.excluirSeguro(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Seguro excluido com sucesso"));
    }
}
