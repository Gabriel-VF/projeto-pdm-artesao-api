package com.example.projeto_pdm_artesao_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto_pdm_artesao_api.dto.VendaRequest;
import com.example.projeto_pdm_artesao_api.dto.VendaResponse;
import com.example.projeto_pdm_artesao_api.service.VendaService;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public ResponseEntity<VendaResponse> registrar(@RequestBody VendaRequest dto) {
        return ResponseEntity.ok(vendaService.registrarVenda(dto));
    }

    @GetMapping("/me")
    public ResponseEntity<List<VendaResponse>> listarMinhasVendas() {
        return ResponseEntity.ok(vendaService.listarMinhasVendas());
    }
}
