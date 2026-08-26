package com.example.projeto_pdm_artesao_api.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artesaos")
public class Artesao {

	@Id
	@Column(name = "artesao_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "telefone", nullable = false)
	private String telefone;

	@Column(name = "identificacao", nullable = false) // identification (CPF/RG/CNPJ), may remove later
	private String identificacao;

	@Column(name = "usuario", nullable = false) // username for login, may change to email later
	private String usuario;

	@Column(name = "senha", nullable = false)
	private String senha;	// Use BCrypt later, compare Hash only

	@OneToMany(mappedBy = "artesao", cascade = CascadeType.ALL)
	private List<Produto> produtos;
	
}
