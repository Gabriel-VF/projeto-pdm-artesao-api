package com.example.projeto_pdm_artesao_api.dto;

import java.time.LocalDateTime;

public record VendaResponse(
        Long id,
        String produtoNome,
        Double valorTotal,
        Integer quantidade,
        String dataHora,
        String artesaoNome,
        String vendedorNome
) {}
