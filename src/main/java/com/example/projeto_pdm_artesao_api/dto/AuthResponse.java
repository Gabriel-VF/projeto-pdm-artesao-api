package com.example.projeto_pdm_artesao_api.dto;

public record AuthResponse(

    String token,
    Long artesaoId,
    String nome
    
) {}