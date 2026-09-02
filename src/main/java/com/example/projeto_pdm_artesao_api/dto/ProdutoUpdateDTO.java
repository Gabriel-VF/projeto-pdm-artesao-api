package com.example.projeto_pdm_artesao_api.dto;

import jakarta.validation.constraints.PositiveOrZero;

public record ProdutoUpdateDTO(

        String nome,

        String descricao,

        @PositiveOrZero
        Double preco

        //@PositiveOrZero 
        //Integer quantidadeEstoque verify business rules

) {}