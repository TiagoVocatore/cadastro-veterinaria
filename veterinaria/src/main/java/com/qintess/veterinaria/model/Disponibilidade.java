package com.qintess.veterinaria.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Disponibilidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(unique=true)
	private String nome;
	@OneToMany(mappedBy="disponibilidade")
	private List <Veterinario> veterinarios;
	
	public Disponibilidade() {
	}

	public Disponibilidade(String nome, List<Veterinario> veterinarios) {
		this.nome = nome;
		this.veterinarios = veterinarios;
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

	public List<Veterinario> getVeterinarios() {
		return veterinarios;
	}

	public void setVeterinarios(List<Veterinario> veterinarios) {
		this.veterinarios = veterinarios;
	}

	
	
	
	
	
	
	
	

}
