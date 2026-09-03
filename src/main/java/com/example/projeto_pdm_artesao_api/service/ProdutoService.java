package com.example.projeto_pdm_artesao_api.service;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.projeto_pdm_artesao_api.dto.ProdutoCreateDTO;
import com.example.projeto_pdm_artesao_api.dto.ProdutoResponse;
import com.example.projeto_pdm_artesao_api.dto.ProdutoUpdateDTO;
import com.example.projeto_pdm_artesao_api.entities.Artesao;
import com.example.projeto_pdm_artesao_api.entities.Produto;
import com.example.projeto_pdm_artesao_api.repositories.ArtesaoRepository;
import com.example.projeto_pdm_artesao_api.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    
    private final ProdutoRepository produtoRepository;
    private final ArtesaoRepository artesaoRepository;

    public ProdutoService(ProdutoRepository produtoRepository, ArtesaoRepository artesaoRepository) {
        this.produtoRepository = produtoRepository;
        this.artesaoRepository = artesaoRepository;
    }

    private Artesao getArtesaoAutenticado() {

        Object principal = SecurityContextHolder
            .getContext()
            .getAuthentication()
            .getPrincipal();

        if (!(principal instanceof Artesao artesao)) {
            throw new RuntimeException(
                    "Artesão não autenticado"
            );
        }

        return artesao;
    }


    @Transactional
    public ProdutoResponse criar(ProdutoCreateDTO dto) {

        Artesao artesao = getArtesaoAutenticado();

        if (produtoRepository.existsByQrCodeId(dto.qrCodeId())) {
            throw new RuntimeException("QR Code já cadastrado");
        }

        Produto produto = new Produto();
        
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());
        produto.setQuantidadeEstoque(dto.quantidadeEstoque());
        produto.setQrCodeId(dto.qrCodeId());
        produto.setArtesao(artesao);

        Produto salvo = produtoRepository.save(produto);
        
        return toResponse(salvo);
    }


    public ProdutoResponse buscarPorId(Long id) {

        Artesao artesao = getArtesaoAutenticado();

        Produto produto = produtoRepository
                .findByIdAndArtesaoId(
                        id,
                        artesao.getId()
                )
                .orElseThrow(() ->
                        new RuntimeException(
                                "Produto não encontrado"
                        )
                );

        return toResponse(produto);
    }

    
    public List<ProdutoResponse> listarMeusProdutos() {

        Artesao artesao = getArtesaoAutenticado();

        return produtoRepository
                .findByArtesaoId(artesao.getId())
                .stream()
                .map(this::toResponse)
                .toList();
    }


    public ProdutoResponse atualizar(
        Long id,
        ProdutoUpdateDTO dto
    ) {

        Artesao artesao = getArtesaoAutenticado();

        Produto produto = produtoRepository
                .findByIdAndArtesaoId(id, artesao.getId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Produto não encontrado"
                        )
                );

        if (dto.nome() != null) {
            produto.setNome(dto.nome());
        }

        if (dto.descricao() != null) {
            produto.setDescricao(dto.descricao());
        }

        if (dto.preco() != null) {
            produto.setPreco(dto.preco());
        }

        //if (dto.quantidadeEstoque() != null) {
        //    produto.setQuantidadeEstoque(
        //            dto.quantidadeEstoque()
        //    );
        //}

        Produto atualizado = produtoRepository.save(produto);

        return toResponse(atualizado);
    }


    public void deletar(Long id) {

        Artesao artesao = getArtesaoAutenticado();

        Produto produto = produtoRepository
                .findByIdAndArtesaoId(id, artesao.getId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Produto não encontrado"
                        )
                );

        produtoRepository.delete(produto);
    }


    private ProdutoResponse toResponse(Produto produto) {

        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getQuantidadeEstoque(),
                produto.getQrCodeId(),
                produto.getArtesao().getId()
        );
    }
}
