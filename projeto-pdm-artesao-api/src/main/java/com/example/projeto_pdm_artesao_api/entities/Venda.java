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
}
