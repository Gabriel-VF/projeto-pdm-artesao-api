package com.example.projeto_pdm_artesao_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projeto_pdm_artesao_api.entities.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findByArtesaoId(Long artesaoId);
}
