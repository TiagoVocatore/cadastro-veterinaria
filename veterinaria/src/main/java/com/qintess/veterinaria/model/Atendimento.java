package com.qintess.veterinaria.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@ManyToOne
	@JoinColumn(name = "animal_codigo")
	private Animal animal;
	@OneToOne
	@JoinColumn(name = "tipo_codigo")
	private TipoAtendimento tipoAtendimento;
	@ManyToOne
	@JoinColumn(name = "veterinario_codigo")
	private Veterinario veterinario;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate data;
	private LocalTime hora;
	
	public Atendimento() {
	}

	public Atendimento(Animal animal, TipoAtendimento tipoAtendimento, Veterinario veterinario, LocalDate data,
			LocalTime hora) {
		super();
		this.animal = animal;
		this.tipoAtendimento = tipoAtendimento;
		this.veterinario = veterinario;
		this.data = data;
		this.hora = hora;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public TipoAtendimento getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return  animal.getNome() + " / " + data + " - " + hora;
	}

	
	
	
	
	
	
}
