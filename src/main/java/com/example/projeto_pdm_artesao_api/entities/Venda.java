package com.example.projeto_pdm_artesao_api.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda {

	@Id
	@Column(name = "venda_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vendaId;

	@Column(name="dataHora", nullable = false)
	private LocalDateTime dataHora; // registry time of a new sale

	@Column(name = "valor", nullable = false)
	private Double valor;

	@ManyToOne(fetch = FetchType.LAZY) // fetch type lazy to load dynamically
	@JoinColumn(name = "artesao_id", nullable = false) // Many sales mapped to one artisan
	private Artesao artesao;

	@OneToMany
	@JoinColumn(name = "produto_id", nullable = false) // one sale may be composed by one or more products
	private List<Produto> produtosPorVenda;

	@ManyToOne
	@JoinColumn(name = "vendedor_id", nullable = false)
	private Vendedor vendedor;

	public Venda() {
	}

	public Venda(Long vendaId, LocalDateTime dataHora, Double valor, Artesao artesao, List<Produto> produtosPorVenda,
			Vendedor vendedor) {
		this.vendaId = vendaId;
		this.dataHora = dataHora;
		this.valor = valor;
		this.artesao = artesao;
		this.produtosPorVenda = produtosPorVenda;
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

	public Artesao getArtesao() {
		return artesao;
	}

	public void setArtesao(Artesao artesao) {
		this.artesao = artesao;
	}

	public List<Produto> getProdutosPorVenda() {
		return produtosPorVenda;
	}

	public void setProdutosPorVenda(List<Produto> produtosPorVenda) {
		this.produtosPorVenda = produtosPorVenda;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
}
