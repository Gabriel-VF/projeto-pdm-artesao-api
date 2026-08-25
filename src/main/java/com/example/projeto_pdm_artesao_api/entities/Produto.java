package com.example.projeto_pdm_artesao_api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	@Column(name = "nome", nullable = false)
	private String nome;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "descricao", nullable = false)
	private String descricao;
	@Column(name = "preco", nullable = false)
	private double preco;
	@Column(name = "quantidade", nullable = false)
	private long quantidade;

	@ManyToOne
	@JoinColumn(name = "artesao_id")
	private Artesao artesao;
	
}
