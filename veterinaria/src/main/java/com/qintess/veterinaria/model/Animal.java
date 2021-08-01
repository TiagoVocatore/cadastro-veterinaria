package com.qintess.veterinaria.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nome;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "especie_codigo", nullable = false)
	private Especie especie;
	private String raca;
	private int Idade;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_codigo", nullable = false)
	private Cliente cliente;
	@OneToMany(mappedBy="animal")
	private List <Atendimento> atendimentos;
	
	public Animal() {
	}


	public Animal(String nome, Especie especie, String raca, int idade, Cliente cliente) {
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		Idade = idade;
		this.cliente = cliente;
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

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public int getIdade() {
		return Idade;
	}

	public void setIdade(int idade) {
		Idade = idade;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		return "Animal [codigo=" + codigo + ", nome=" + nome + ", especie=" + especie.getNome() + ", raca=" + raca + ", Idade="
				+ Idade + ", cliente=" + cliente.getNome() + "]";
	}


}
