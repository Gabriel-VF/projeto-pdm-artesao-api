package com.example.projeto_pdm_artesao_api.dto;

import jakarta.validation.constraints.NotBlank;

public record ArtesaoCreateDTO(

    @NotBlank String nome,
    @NotBlank String telefone,
    @NotBlank String email,
    @NotBlank String senha

) {}