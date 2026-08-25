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
@Table(name = "venda")
public class Venda {
	@Id
	@Column(name = "venda_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vendaId;
	@ManyToOne
	@JoinColumn(name = "vendedor_id")
	private Vendedor vendedor;
	@Column(name = "valor", nullable = false)
	private double valor;
}
