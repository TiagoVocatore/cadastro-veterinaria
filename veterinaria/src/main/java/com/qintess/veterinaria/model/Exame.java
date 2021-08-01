package com.qintess.veterinaria.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Exame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(unique=true)
	private String nome;
	@ManyToMany(mappedBy="exames")
	private List<Prontuario> prontuarios;
	
	public Exame() {
	}

	public Exame(String nome, List<Prontuario> prontuarios) {
		this.nome = nome;
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
