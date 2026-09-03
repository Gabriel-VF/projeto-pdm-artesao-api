package com.example.projeto_pdm_artesao_api.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @Column(name = "venda_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendaId;

    @Column(name = "dataHora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artesao_id", nullable = false)
    private Artesao artesao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendedor_id", nullable = true)
    private Vendedor vendedor;

    public Venda() {
    }

    public Venda(Long vendaId, LocalDateTime dataHora, Double valor, Integer quantidade, Artesao artesao, Produto produto, Vendedor vendedor) {
        this.vendaId = vendaId;
        this.dataHora = dataHora;
        this.valor = valor;
        this.quantidade = quantidade;
        this.artesao = artesao;
        this.produto = produto;
        this.vendedor = vendedor;
    }

    public Long getVendaId() {
        return vendaId;
    }

    public void setVendaId(Long vendaId) {
        this.vendaId = vendaId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Artesao getArtesao() {
        return artesao;
    }

    public void setArtesao(Artesao artesao) {
        this.artesao = artesao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
