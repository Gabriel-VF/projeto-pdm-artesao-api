package com.example.projeto_pdm_artesao_api.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.projeto_pdm_artesao_api.dto.VendaRequest;
import com.example.projeto_pdm_artesao_api.dto.VendaResponse;
import com.example.projeto_pdm_artesao_api.entities.Artesao;
import com.example.projeto_pdm_artesao_api.entities.Produto;
import com.example.projeto_pdm_artesao_api.entities.Venda;
import com.example.projeto_pdm_artesao_api.repositories.ProdutoRepository;
import com.example.projeto_pdm_artesao_api.repositories.VendaRepository;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final ProdutoRepository produtoRepository;

    public VendaService(VendaRepository vendaRepository, ProdutoRepository produtoRepository) {
        this.vendaRepository = vendaRepository;
        this.produtoRepository = produtoRepository;
    }

    private Artesao getArtesaoAutenticado() {
        return (Artesao) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Transactional
    public VendaResponse registrarVenda(VendaRequest dto) {
        Artesao artesao = getArtesaoAutenticado();
        Produto produto = produtoRepository.findById(dto.produtoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (!produto.getAtivo()) {
            throw new RuntimeException("Produto inativo e não pode ser vendido");
        }

        if (produto.getQuantidadeEstoque() < dto.quantidade()) {
            throw new RuntimeException("Estoque insuficiente. Disponível: " + produto.getQuantidadeEstoque());
        }

        // Decrementa o estoque
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - dto.quantidade());
        produtoRepository.save(produto);

        Venda venda = new Venda();
        venda.setDataHora(LocalDateTime.now());
        venda.setValor(produto.getPreco() * dto.quantidade());
        venda.setQuantidade(dto.quantidade());
        venda.setArtesao(artesao);
        venda.setProduto(produto);
        // vendedor_id agora é opcional na entidade Venda.java, 
        // pois o Artesão atua como vendedor neste fluxo.

        Venda salva = vendaRepository.save(venda);
        return mapToResponse(salva);
    }

    public List<VendaResponse> listarMinhasVendas() {
        Artesao artesao = getArtesaoAutenticado();
        return vendaRepository.findByArtesaoId(artesao.getId())
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private VendaResponse mapToResponse(Venda venda) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return new VendaResponse(
                venda.getVendaId(),
                venda.getProduto().getNome(),
                venda.getValor(),
                venda.getQuantidade(),
                venda.getDataHora().format(formatter),
                venda.getArtesao().getNome(),
                venda.getVendedor() != null ? venda.getVendedor().getNome() : venda.getArtesao().getNome()
        );
    }
}
