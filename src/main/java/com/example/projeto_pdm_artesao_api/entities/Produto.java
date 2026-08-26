package com.example.projeto_pdm_artesao_api.entities;

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
@Table(name = "produtos")
public class Produto {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "preco", nullable = false)
	private Double preco;

	@Column(name = "quantidade_estoque", nullable = false)
	private Integer quantidadeEstoque;

	@Column(name = "qr_code_id", unique = true, nullable = false)
	private String qrCodeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artesao_id", nullable = false)
	private Artesao artesao;

	public Produto() {
	}

	public Produto(Long id, String nome, String descricao, Double preco, Integer quantidadeEstoque, String qrCodeId,
			Artesao artesao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
		this.qrCodeId = qrCodeId;
		this.artesao = artesao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getQrCodeId() {
		return qrCodeId;
	}

	public void setQrCodeId(String qrCodeId) {
		this.qrCodeId = qrCodeId;
	}

	public Artesao getArtesao() {
		return artesao;
	}

	public void setArtesao(Artesao artesao) {
		this.artesao = artesao;
	}
	
}
