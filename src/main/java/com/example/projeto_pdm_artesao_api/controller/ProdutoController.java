package com.example.projeto_pdm_artesao_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto_pdm_artesao_api.dto.ProdutoCreateDTO;
import com.example.projeto_pdm_artesao_api.dto.ProdutoResponse;
import com.example.projeto_pdm_artesao_api.dto.ProdutoUpdateDTO;
import com.example.projeto_pdm_artesao_api.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> criar(
        @Valid @RequestBody ProdutoCreateDTO dto
    ) {
        
        ProdutoResponse response = produtoService.criar(dto);

        return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarPorId(
        @PathVariable Long id
    ) {

        return ResponseEntity.ok(
            produtoService.buscarPorId(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listarMeusProdutos() {

        return ResponseEntity.ok(
            produtoService.listarMeusProdutos()
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar(
        @PathVariable Long id,
        @Valid @RequestBody ProdutoUpdateDTO dto
    ) {

        return ResponseEntity.ok(
            produtoService.atualizar(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
        @PathVariable Long id
    ) {

        produtoService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
