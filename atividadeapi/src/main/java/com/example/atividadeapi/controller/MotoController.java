package com.example.atividadeapi.controller;

import com.example.atividadeapi.entity.MotoEntity;
import com.example.atividadeapi.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class MotoController {
    @Autowired
    private MotoService motoService;

    @GetMapping
    public List<MotoEntity> listarTodos() {return motoService.listarTodasMotos(); }

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar (@RequestBody MotoEntity moto){
        motoService.salvarMoto(moto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Moto cadastrada com sucesso!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(@PathVariable Long id, @RequestBody MotoEntity moto ){
        motoService.atualizarMoto(id, moto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Moto atualizada com sucesso!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletar(@PathVariable Long id){
        motoService.deletarMoto(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Moto deletada com sucesso!"));
    }
}
