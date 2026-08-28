package com.example.projeto_pdm_artesao_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto_pdm_artesao_api.dto.ArtesaoCreateDTO;
import com.example.projeto_pdm_artesao_api.dto.ArtesaoResponse;
import com.example.projeto_pdm_artesao_api.dto.AuthResponse;
import com.example.projeto_pdm_artesao_api.dto.LoginRequest;
import com.example.projeto_pdm_artesao_api.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<ArtesaoResponse> cadastrar(
        @Valid @RequestBody ArtesaoCreateDTO dto
    ) {

        ArtesaoResponse response = authService.cadastrar(dto);

        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(response);

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
        @Valid @RequestBody LoginRequest dto
    ) {

        AuthResponse response = authService.login(dto);

        return ResponseEntity.ok(response);
    }
}