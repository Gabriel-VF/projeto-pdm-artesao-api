package com.example.projeto_pdm_artesao_api.dto;

public record ProdutoResponse(

        Long id,
        String nome,
        String descricao,
        Double preco,
        Integer quantidadeEstoque,
        String qrCodeId,
        Long artesaoId,
        Boolean ativo

) {}