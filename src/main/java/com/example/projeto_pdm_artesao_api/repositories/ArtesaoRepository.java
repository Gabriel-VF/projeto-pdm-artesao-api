package com.example.projeto_pdm_artesao_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto_pdm_artesao_api.entities.Artesao;

public interface ArtesaoRepository extends JpaRepository<Artesao, Long> {
}
