package com.qintess.veterinaria.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Especie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nome;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="especie")
	private List <Animal> animais;
	@ManyToMany(mappedBy="especies")
	private List<Veterinario> veterinarios;
	
	
	public Especie() {
	}


	public Especie(String nome, List<Animal> animais, List<Veterinario> veterinarios) {
		this.nome = nome;
		this.animais = animais;
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


	public List<Animal> getAnimais() {
		return animais;
	}


	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}


	public List<Veterinario> getVeterinarios() {
		return veterinarios;
	}


	public void setVeterinarios(List<Veterinario> veterinarios) {
		this.veterinarios = veterinarios;
	}


	@Override
	public String toString() {
		return nome;
	}


	
	



	
   

	
}
