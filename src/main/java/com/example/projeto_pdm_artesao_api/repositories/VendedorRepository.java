package com.example.projeto_pdm_artesao_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projeto_pdm_artesao_api.entities.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
