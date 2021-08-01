package com.qintess.veterinaria.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Veterinario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nome;
	private String endereco;
	@Column(unique=true)
	private String crmv;
	@ManyToMany
	@JoinTable(name="especie_veterinario",
	uniqueConstraints = @UniqueConstraint(columnNames = {"veterinario_codigo", 
			"especie_codigo"}),
	joinColumns = @JoinColumn(name="veterinario_codigo"),
	inverseJoinColumns = @JoinColumn(name="especie_codigo"))
	private List<Especie> especies;
	@OneToMany(mappedBy="veterinario")
	private List <Atendimento> atendimentos;
	@ManyToOne
	@JoinColumn(name = "disponibilidade_codigo", nullable = false)
	private Disponibilidade disponibilidade;
	
	public Veterinario() {
	}

	public Veterinario(String nome, String endereco, String crmv, List<Especie> especies,
			List<Atendimento> atendimentos, Disponibilidade disponibilidade) {
		this.nome = nome;
		this.endereco = endereco;
		this.crmv = crmv;
		this.especies = especies;
		this.atendimentos = atendimentos;
		this.disponibilidade = disponibilidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCrmv() {
		return crmv;
	}

	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}

	public List<Especie> getEspecies() {
		return especies;
	}

	public void setEspecies(List<Especie> especies) {
		this.especies = especies;
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Disponibilidade getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Disponibilidade disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	

	
	
	
	
	
	

	
}
