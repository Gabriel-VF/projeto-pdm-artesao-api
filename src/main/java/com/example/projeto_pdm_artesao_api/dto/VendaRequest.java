package com.example.projeto_pdm_artesao_api.dto;

public record VendaRequest(
        Long produtoId,
        Integer quantidade
) {}
