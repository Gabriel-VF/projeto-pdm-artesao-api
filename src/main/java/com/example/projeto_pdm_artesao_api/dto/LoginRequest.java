package com.example.projeto_pdm_artesao_api.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(

    @NotBlank(message = "E-mail é obrigatório") String email,
    @NotBlank(message = "Senha é obrigatória") String senha
    
) {}
