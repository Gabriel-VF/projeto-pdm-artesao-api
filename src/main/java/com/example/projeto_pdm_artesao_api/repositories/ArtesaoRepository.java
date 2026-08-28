package com.example.projeto_pdm_artesao_api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto_pdm_artesao_api.entities.Artesao;

public interface ArtesaoRepository extends JpaRepository<Artesao, Long> {

    Optional<Artesao> findByEmail(String email);

    boolean existsByEmail(String email);
    
}
