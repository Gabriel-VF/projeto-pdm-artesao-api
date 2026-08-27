package com.example.projeto_pdm_artesao_api.service;

import com.example.projeto_pdm_artesao_api.dto.ArtesaoCreateDTO;
import com.example.projeto_pdm_artesao_api.dto.ArtesaoResponse;
import com.example.projeto_pdm_artesao_api.entities.Artesao;
import com.example.projeto_pdm_artesao_api.repositories.ArtesaoRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final ArtesaoRepository artesaoRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService( // constructor DI
        ArtesaoRepository artesaoRepository,
        PasswordEncoder passwordEncoder
    ) {
        this.artesaoRepository = artesaoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ArtesaoResponse cadastrar(ArtesaoCreateDTO dto) {

        if (artesaoRepository.existsByEmail(dto.email())) {
            throw new RuntimeException("E-mail já cadastrado");
        }

        Artesao artesao = new Artesao();

        artesao.setNome(dto.nome());
        artesao.setTelefone(dto.telefone());
        artesao.setIdentificacao(dto.identificacao());
        artesao.setEmail(dto.email());

        String senhaHash = passwordEncoder.encode(dto.senha());

        artesao.setSenha(senhaHash);

        Artesao salvo = artesaoRepository.save(artesao);

        return new ArtesaoResponse(
            salvo.getId(),
            salvo.getNome(),
            salvo.getTelefone(),
            salvo.getIdentificacao(),
            salvo.getEmail()
        );
    }
}