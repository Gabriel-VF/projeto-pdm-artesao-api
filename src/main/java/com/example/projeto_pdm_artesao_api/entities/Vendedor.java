package com.example.projeto_pdm_artesao_api.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendedor")
public class Vendedor {
	@Id
	@Column(name = "vendedor_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "telefone", nullable = false)
	private String telefone;
	@Column(name = "senha", nullable = false)
	private String senha;

	@OneToMany(mappedBy = "vendedor")
	private List<Venda> vendas;
}
