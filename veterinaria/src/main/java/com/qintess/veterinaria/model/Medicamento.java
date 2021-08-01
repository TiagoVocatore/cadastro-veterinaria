package com.qintess.veterinaria.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Medicamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(unique=true)
	private String nome;
	@Column(columnDefinition = "text")
	private String descricao;
	@ManyToMany(mappedBy="medicamentos")
	private List<Prontuario> prontuarios;
	
	public Medicamento() {
	}

	public Medicamento(String nome, String descricao, List<Prontuario> prontuarios) {
		this.nome = nome;
		this.descricao = descricao;
		this.prontuarios = prontuarios;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Prontuario> getProntuarios() {
		return prontuarios;
	}

	public void setProntuarios(List<Prontuario> prontuarios) {
		this.prontuarios = prontuarios;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
	

	
	
	
	

}
