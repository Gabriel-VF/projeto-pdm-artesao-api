package com.example.projeto_pdm_artesao_api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto_pdm_artesao_api.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    List<Produto> findByArtesaoId(Long artesaoId);

    Optional<Produto> findByIdAndArtesaoId(Long id, Long artesaoId);

    boolean existsByQrCodeId(String qrCodeId);

}
