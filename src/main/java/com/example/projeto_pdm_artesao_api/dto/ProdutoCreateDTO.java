package com.example.projeto_pdm_artesao_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ProdutoCreateDTO(

        @NotBlank String nome,

        @NotBlank String descricao,

        @NotNull
        @PositiveOrZero
        Double preco,

        @NotNull
        @PositiveOrZero
        Integer quantidadeEstoque

) {}