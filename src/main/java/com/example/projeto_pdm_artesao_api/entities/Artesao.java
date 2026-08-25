package com.example.projeto_pdm_artesao_api.entities;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artesao")
public class Artesao {
	@Id
	@Column(name = "artesao_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "telefone", nullable = false)
	private String telefone;
	@Column(name = "senha", nullable = false)
	private String senha;

	@OneToMany(mappedBy = "artesao")
	@OnDelete(action = OnDeleteAction.SET_NULL)
	private List<Produto> produtos;
}
